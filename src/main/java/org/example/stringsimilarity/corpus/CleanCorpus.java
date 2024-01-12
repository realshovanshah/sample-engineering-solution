package org.example.stringsimilarity.corpus;

import java.util.Arrays;
import java.util.List;

public class CleanCorpus {

    private CleanCorpus(){}

    public final static List<List<String>> life = List.of(
            Arrays.asList("the", "game", "of", "life", "is", "a", "game", "of", "everlasting", "learning"),
            Arrays.asList("the", "unexamined", "life", "is", "not", "worth", "living"),
            Arrays.asList("never", "stop", "learning"));

    public final static List<List<String>> food = List.of(
            List.of("she", "loves", "food", "with", "cheese"),
            List.of("her", "favorite", "food", "is", "italian"),
            List.of("she", "lives", "in", "italian", "state")
    );

}
