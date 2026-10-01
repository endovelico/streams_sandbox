package com.streams.sandbox.custom.algos;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamSieve {

    public static Stream<Integer> primes(int limit) {

        return Stream.iterate(
                        IntStream.rangeClosed(2, limit)
                                .boxed()
                                .toList(),

                        numbers -> numbers.isEmpty()
                                ? List.of()
                                : numbers.stream()
                                .skip(1)
                                .filter(n -> n % numbers.get(0) != 0)
                                .toList()
                )
                .takeWhile(list -> !list.isEmpty())
                .map(list -> list.get(0));
    }
}
