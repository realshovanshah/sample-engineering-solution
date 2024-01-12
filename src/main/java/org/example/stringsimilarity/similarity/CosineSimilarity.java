package org.example.stringsimilarity.similarity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class CosineSimilarity implements Similarity {
    @Override
    public @NotNull Double calculate(@NotNull List<Double> vectorA, @NotNull List<Double> vectorB) {
        if (vectorA.size() != vectorB.size()) throw new IllegalArgumentException("Vectors must have the same dimension");

        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.size(); i++) {
            dotProduct += vectorA.get(i) * vectorB.get(i);
            normA += pow(vectorA.get(i), 2);
            normB += pow(vectorB.get(i), 2);
        }
        return (normA == 0.0 || normB == 0.0) ? 0.0
                : dotProduct / (sqrt(normA) * sqrt(normB));
    }
}
