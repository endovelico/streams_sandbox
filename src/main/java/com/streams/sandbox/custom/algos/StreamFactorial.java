package com.streams.sandbox.custom.algos;

import java.util.stream.IntStream;

public class StreamFactorial {

    public static long factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .asLongStream()
                .reduce(1, (a, b) -> a * b);
    }
}
