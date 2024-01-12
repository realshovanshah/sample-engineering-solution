package org.example.stringsimilarity.bagofwords;

import org.example.stringsimilarity.corpus.CleanCorpus;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TfIdfTest {

    final TfIdf subject = new TfIdf();

    @Test
    public void tf_happyPath() {
        final double termFrequency = subject.tf("one", Arrays.asList("one", "two", "three"));
        assertEquals(0.33, termFrequency, 0.01);
    }

    @Test
    public void idf_moreOccurrenceLowScore() {
        final double inverseDocumentFrequency = subject.idf("learning", CleanCorpus.life);
        assertEquals(1.41, inverseDocumentFrequency, 0.01);
    }

    @Test
    public void idf_lowOccurrenceHighScore() {
        final double inverseDocumentFrequency = subject.idf("game", CleanCorpus.life);
        assertEquals(2.10, inverseDocumentFrequency, 0.01);
    }

    @Test(expected = Exception.class)
    public void idf_faultyCorpusThrowsAnException() {
        subject.idf("haha", Arrays.asList(
                Arrays.asList("one", "two"),
                Arrays.asList("three", "four")
        ));
    }

    @Test
    public void tfIdf_corpus1() {
//        Data source: https://dotnettutorials.net/lesson/tf-idf-and-cosinesimilarity-in-machine-learning/
        final var corpus2 = CleanCorpus.food;

        final var lovesD1 = subject.calculate("loves", corpus2.get(0), corpus2);
        final var italianD2 = subject.calculate("italian", corpus2.get(1), corpus2);
        final var cheeseD3 = subject.calculate("cheese", corpus2.get(2), corpus2);

        assertEquals(0.41, lovesD1, 0.01);
        assertEquals(0.28, italianD2, 0.01);
        assertEquals(0.0, cheeseD3, 0);
    }

    @Test
    public void tfIdf_corpus2() {
//        Data source: https://janav.wordpress.com/2013/10/27/tf-idf-and-cosine-similarity/
        final List<List<String>> corpus = CleanCorpus.life;

        final var lifeD1 = subject.calculate("life", corpus.get(0), corpus);
        final var lifeD2 = subject.calculate("life", corpus.get(1), corpus);
        final var learningD2 = subject.calculate("learning", corpus.get(1), corpus);
        final var learningD3 = subject.calculate("learning", corpus.get(2), corpus);

        assertEquals(0.14, lifeD1, 0.01);
        assertEquals(0.20, lifeD2, 0.01);
        assertEquals(0, learningD2, 0);
        assertEquals(0.46, learningD3, 0.01);
    }

}