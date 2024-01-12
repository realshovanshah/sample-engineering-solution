package org.example.stringsimilarity.similarity;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CosineSimilarityTest {

    final CosineSimilarity cosineSimilarity = new CosineSimilarity();
    @Test
    public void testCosineSimilarity() {
        List<Double> vector1 = Arrays.asList(1.0, 2.0, 3.0);
        List<Double> vector2 = Arrays.asList(4.0, 5.0, 6.0);
        double similarity = cosineSimilarity.calculate(vector1, vector2);
        assertEquals(0.97, similarity, 0.01);
    }

    @Test
    public void testCosineSimilarityWithZeroVector() {
        List<Double> vector1 = Arrays.asList(0.0, 0.0, 0.0);
        List<Double> vector2 = Arrays.asList(1.0, 2.0, 3.0);
        double similarity = cosineSimilarity.calculate(vector1, vector2);
        assertEquals(0.0, similarity, 0.0);
    }

    @Test
    public void testCosineSimilarityWithNegativeValues() {
        List<Double> vector1 = Arrays.asList(-1.0, -2.0, -3.0);
        List<Double> vector2 = Arrays.asList(-4.0, -5.0, -6.0);
        double similarity = cosineSimilarity.calculate(vector1, vector2);
        assertEquals(0.97, similarity, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCosineSimilarityWithDifferentLengths() {
        List<Double> vector1 = Arrays.asList(1.0, 2.0, 3.0);
        List<Double> vector2 = Arrays.asList(4.0, 5.0);
        cosineSimilarity.calculate(vector1, vector2);
    }
}