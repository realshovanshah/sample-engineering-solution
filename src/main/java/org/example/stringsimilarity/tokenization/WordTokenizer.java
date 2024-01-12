package org.example.stringsimilarity.tokenization;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class WordTokenizer {

    private WordTokenizer(){}

    @NotNull
    public static List<String> tokenize(@NotNull String document) {
        return tokenize(document,true);
    }

    @NotNull
    public static List<String> tokenize(@NotNull String document, @NotNull Boolean lowerCase) {
        if (document.isEmpty()) return Collections.emptyList();
        final String[] tokens =document.split("(\\W+\\s+|\\W+$)|\\s");
        if (!lowerCase) return Arrays.asList(tokens);
        return Arrays.stream(tokens).map(String::toLowerCase).collect(Collectors.toList());
    }
}