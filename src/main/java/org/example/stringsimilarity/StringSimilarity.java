package org.example.stringsimilarity;

import org.example.stringsimilarity.bagofwords.Vectorizer;
import org.example.stringsimilarity.similarity.Similarity;
import org.example.stringsimilarity.tokenization.WordTokenizer;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static org.example.stringsimilarity.utils.ListUtils.stringifyNdList;

public class StringSimilarity {

    private static final Logger LOGGER = Logger.getLogger(StringSimilarity.class.getName());
    final Vectorizer vectorizer;
    final Similarity similarity;

    public StringSimilarity(Vectorizer vectorizer, Similarity similarity) {
        this.vectorizer = vectorizer;
        this.similarity = similarity;
    }

    /**
     * Calculates similarity probability using a vector similarity algorithm from a bag of words representation.<br>
     * @apiNote The `max` function is used to calculate an exact probability from a set of similarities with other documents.
     * @return A list of probability for every document; 1 means a wholly similar, and 0 is a totally new string.
     */
    public @NotNull List<Double> calculateProbability(@NotNull Set<String> documents) {
        final var readyCorpus = documents.stream().map(WordTokenizer::tokenize).collect(toCollection(LinkedHashSet::new));
        LOGGER.log(Level.INFO, "Processed Corpus\n" + stringifyNdList(List.of(readyCorpus.toArray())) + "\n");
        var bowByDocument = vectorizer.transform(readyCorpus);
        LOGGER.log(Level.INFO, "Bag of Words Representation\n" + stringifyNdList((List<?>) bowByDocument) + "\n");

        // Using a {@code max} function
        return bowByDocument.stream()
                .map(i -> bowByDocument.stream()
                        .filter(j -> i != j)
                        .mapToDouble(j -> similarity.calculate(i, j))
                        .max().orElse(0.0))
                .collect(toList());
    }
}
