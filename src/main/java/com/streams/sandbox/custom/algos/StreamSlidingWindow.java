package com.streams.sandbox.custom.algos;

import java.util.List;
import java.util.stream.IntStream;

public class StreamSlidingWindow {

    public static IntStream slidingWindowSums(
            List<Integer> numbers,
            int windowSize) {

        return IntStream.rangeClosed(
                0,
                numbers.size() - windowSize
        ).map(i ->
                numbers.stream()
                        .skip(i)
                        .limit(windowSize)
                        .mapToInt(Integer::intValue)
                        .sum()
        );
    }
}
