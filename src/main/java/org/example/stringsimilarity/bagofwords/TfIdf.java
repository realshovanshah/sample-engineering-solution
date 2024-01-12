package org.example.stringsimilarity.bagofwords;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Math.log;

/*
 * TODO: parameterize TFIDF normalization variants (eg: log base, weighing function)
 */
public class TfIdf {

    private static final Map<String, Double> idfCache = new ConcurrentHashMap<>();

    private static final Logger LOGGER = Logger.getLogger(TfIdf.class.getName());

    public double tf(@NotNull String term, @NotNull List<String> document) {
        final long termOccurrence = document.stream().filter(word -> word.equals(term)).count();
        final double termFrequency = (double) termOccurrence / document.size();
        LOGGER.log(Level.FINE, "TF for the term, '" + term + "' is: " + termFrequency);
        return termFrequency;
    }

    /**
     * @throws BadCorpusException when the term doesn't exist in the corpus
     */
    public double idf(@NotNull String term, @NotNull Collection<List<String>> corpus) {
        final long numDocsContainingTerm = corpus.stream().filter(doc -> doc.contains(term)).count();
        if (numDocsContainingTerm == 0) throw new BadCorpusException("This term doesn't exist in the corpus.");
        final double inverseDocumentFrequency = 1.0 + log((double) corpus.size() / numDocsContainingTerm);
        LOGGER.log(Level.FINE, "IDF for the term, '" + term + "' is: " + inverseDocumentFrequency);
        return inverseDocumentFrequency;
    }


    /**
     * TODO: memoize
     * @return TF-IDF value of {@code term} in {@code document}, for a given corpus.
     */
    public double calculate(@NotNull String term, @NotNull List<String> document, @NotNull Collection<List<String>> corpus) {
        final double tfIdf = tf(term, document) * idfCache.computeIfAbsent(term, v -> idf(v, corpus));
        LOGGER.log(Level.FINE, "TF-IDF for the term, '" + term + "' in document '" + document + "' is: " + tfIdf);
        return tfIdf;
    }
}
