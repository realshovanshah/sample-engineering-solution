package org.example.stringsimilarity.tokenization;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordTokenizerTest {

    @Test
    public void testTokenize() {
        String string = "This is a test sentence. It has punctuation, numbers 123, and spaces.";
        List<String> expectedTokens = Arrays.asList("This","is", "a", "test", "sentence", "It", "has", "punctuation", "numbers", "123", "and", "spaces");
        List<String> actualTokens = WordTokenizer.tokenize(string, false);
        assertEquals(expectedTokens, actualTokens);
    }

    @Test
    public void testTokenizeCase() {
        String string = "This is a test sentence. It has punctuation, numbers 123, and spaces.";
        List<String> expectedTokens = Arrays.asList("this","is", "a", "test", "sentence", "it", "has", "punctuation", "numbers", "123", "and", "spaces");
        List<String> actualTokens = WordTokenizer.tokenize(string);
        assertEquals(expectedTokens, actualTokens);
    }

    @Test
    public void testTokenizeRepeatedSpaces() {
        String string = "String  with  multiple spaces    ";
        List<String> expectedTokens = Arrays.asList("String", "with", "multiple", "spaces");
        List<String> actualTokens = WordTokenizer.tokenize(string, false);
        assertEquals(expectedTokens, actualTokens);
    }

    @Test
    public void testTokenizePunctuation() {
        String string = "Hi, It's me. I'm him...";
        List<String> expectedTokens = Arrays.asList("Hi", "It's", "me", "I'm", "him");
        List<String> actualTokens = WordTokenizer.tokenize(string, false);
        assertEquals(expectedTokens, actualTokens);
    }

    @Test
    public void testTokenizeUrl() {
        String string = "A url, https://www.wikipedia.org. Another url: ecosia.org";
        List<String> expectedTokens = Arrays.asList("A", "url", "https://www.wikipedia.org", "Another", "url", "ecosia.org");
        List<String> actualTokens = WordTokenizer.tokenize(string, false);
        assertEquals(expectedTokens, actualTokens);
    }

    @Test
    public void testTokenizeParagraph() {
        String string = "First line,\n"
                + "\n"
                + "Second line\n"
                + "\n"
                + "\n"
                + "Last Line.\n";
        List<String> expectedTokens = Arrays.asList("First", "line", "Second", "line", "Last", "Line");
        List<String> actualTokens = WordTokenizer.tokenize(string, false);
        assertEquals(expectedTokens, actualTokens);
    }
}