package com.streams.sandbox.custom.algos;

import java.util.stream.Stream;

public class StreamCollatz {

    public static Stream<Long> collatz(long n) {
        return Stream.concat(
                Stream.iterate(
                        n,
                        x -> x % 2 == 0 ? x / 2 : 3 * x + 1
                ).takeWhile(x -> x != 1),
                Stream.of(1L)
        );
    }
}
