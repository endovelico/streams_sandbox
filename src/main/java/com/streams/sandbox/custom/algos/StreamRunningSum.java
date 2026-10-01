package com.streams.sandbox.custom.algos;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRunningSum {

    public static Stream<Integer> runningSum(List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj(i ->
                        numbers.stream()
                                .limit(i + 1)
                                .mapToInt(Integer::intValue)
                                .sum()
                );
    }
}
