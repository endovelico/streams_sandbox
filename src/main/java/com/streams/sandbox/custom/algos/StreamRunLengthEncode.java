package com.streams.sandbox.custom.algos;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamRunLengthEncode {

    public static String runLengthEncode(String input) {

        return IntStream.range(0, input.length())
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(
                        i,
                        input.charAt(i)
                ))
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .map(e -> e.getKey() + String.valueOf(e.getValue()))
                .collect(Collectors.joining());
    }
}
