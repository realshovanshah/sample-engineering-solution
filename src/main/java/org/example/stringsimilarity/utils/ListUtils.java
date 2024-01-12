package org.example.stringsimilarity.utils;

import java.util.List;

public class ListUtils {
    private ListUtils() {}

    /**
     * TODO: 23/10/2023 implement for {@code Collection} class
     */
    public static String stringifyNdList(List<?> val){
        return val.toString().replace("], ", "]\n");
    }
}
