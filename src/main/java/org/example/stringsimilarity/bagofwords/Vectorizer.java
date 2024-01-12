package org.example.stringsimilarity.bagofwords;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public interface Vectorizer {
    /**
     * @return A tokenized bow vector for each word in the corpus.
     */
    @NotNull
    Collection<List<Double>> transform(@NotNull Collection<List<String>> corpus);
}
