package org.example.stringsimilarity;

import org.example.stringsimilarity.bagofwords.TfIdf;
import org.example.stringsimilarity.bagofwords.TfIdfVectorizer;
import org.example.stringsimilarity.corpus.RawDocuments;
import org.example.stringsimilarity.similarity.CosineSimilarity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringSimilarityTest {

    StringSimilarity subject = null;

    private void assertSimilarGTUnique(double similar, double Unique){
        assertTrue("similar (" + similar + ") is greater than Unique (" + Unique + ")", similar > Unique);
    }

    @Before
    public void setUp() {
        final var tfidf = new TfIdf();
        subject = new StringSimilarity(new TfIdfVectorizer(tfidf), new CosineSimilarity());
    }

    @Test
    public void testCalculateProbability1(){
        final var probabilities = subject.calculateProbability(RawDocuments.sample2);
        final var similar = probabilities.get(0);
        final var unique = probabilities.get(1);
        assertSimilarGTUnique(similar, unique);
    }

    @Test
    public void testCalculateProbability3(){
        final var probabilities = subject.calculateProbability(RawDocuments.sample3);
        final var similar = probabilities.get(0);
        final var unique = probabilities.get(1);
        assertSimilarGTUnique(similar, unique);
    }

}