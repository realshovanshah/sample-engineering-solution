package org.example.stringsimilarity;

import org.example.stringsimilarity.bagofwords.TfIdf;
import org.example.stringsimilarity.bagofwords.TfIdfVectorizer;
import org.example.stringsimilarity.corpus.RawDocuments;
import org.example.stringsimilarity.similarity.CosineSimilarity;

import java.util.Arrays;
import java.util.stream.IntStream;

class App {
    public static void main(String[] args) {
        final var tfIdf = new TfIdf();
        final var tfIdfVectorizer = new TfIdfVectorizer(tfIdf);

        final var cosineSimilarity = new CosineSimilarity();
        final var documents = RawDocuments.sample1;

        final var stringSimilarity = new StringSimilarity(tfIdfVectorizer, cosineSimilarity);
        final var stringSimilarityProbability = stringSimilarity.calculateProbability(documents);

        if (documents.isEmpty()) System.out.println("No document to process!");
        else System.out.println("Similarity Probability by Document Order:\n"
                + Arrays.toString(IntStream.range(0, documents.size()).toArray()) + "\n"
                + stringSimilarityProbability);
    }
}
