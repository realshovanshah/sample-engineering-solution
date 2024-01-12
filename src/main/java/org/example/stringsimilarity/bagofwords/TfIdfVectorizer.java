package org.example.stringsimilarity.bagofwords;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class TfIdfVectorizer implements Vectorizer{
    final TfIdf tfIdf;

    public TfIdfVectorizer(TfIdf tfIdf) {
        this.tfIdf = tfIdf;
    }

    /**
     * @return A tokenized Bag of Words vector with TF-IDF for each word in the corpus.
     */
    @Override
    public @NotNull Collection<List<Double>> transform(@NotNull Collection<List<String>> corpus) {
        var vocab = corpus.stream().flatMap(Collection::stream).collect(toSet());
        return corpus.stream().map(document -> {
            return vocab.stream().map(term -> tfIdf.calculate(term, document, corpus)).collect(toList());
        }).collect(toList());
    }


}
