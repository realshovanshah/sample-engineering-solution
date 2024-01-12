package org.example.stringsimilarity.similarity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Similarity {
    /**
     * @return Cosine Similarity i.e. a real number between the interval [-1,1].<br>
     * Note that for vectors with non-negative values (associated with some algorithms like TF-IDF), the interval is bounded to [0,1].
     * @throws IllegalArgumentException if the two vectors aren't of the same size
     */
    public @NotNull Double calculate(@NotNull List<Double> vectorA, @NotNull List<Double> vectorB);
}
