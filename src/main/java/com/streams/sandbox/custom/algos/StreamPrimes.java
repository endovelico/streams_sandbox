package com.streams.sandbox.custom.algos;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrimes {

    public static Stream<Integer> primes(int limit) {

        return IntStream.rangeClosed(2, limit)
                .filter(n -> IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0))
                .boxed();
    }

}
