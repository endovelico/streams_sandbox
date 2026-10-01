package com.streams.sandbox.custom.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPascalsTriangle {

    public static Stream<List<Integer>> pascalTriangle() {

        return Stream.iterate(
                List.of(1),
                row -> {
                    List<Integer> next = new ArrayList<>();

                    next.add(1);

                    IntStream.range(0, row.size() - 1)
                            .mapToObj(i -> row.get(i) + row.get(i + 1))
                            .forEach(next::add);

                    next.add(1);

                    return next;
                }
        );
    }
}
