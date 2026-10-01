package com.streams.sandbox.custom.algos;

import java.util.stream.Stream;

public class StreamFibonnaci {

    public static void main(String[] args) {
        Stream.iterate(
                        new long[]{0, 1},
                        pair -> new long[]{pair[1], pair[0] + pair[1]}
                )
                .limit(10)
                .map(pair -> pair[0])
                .forEach(System.out::println);
    }
}
