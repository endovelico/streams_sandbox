package com.streams.sandbox.custom.algos;

import java.util.stream.Stream;

public class StreamGCD {

    public static long gcd(long a, long b) {
        return Stream.iterate(
                        new long[]{a, b},
                        pair -> new long[]{pair[1], pair[0] % pair[1]}
                )
                .takeWhile(pair -> pair[1] != 0)
                .reduce((first, second) -> second)
                .orElseThrow()[0];
    }

}
