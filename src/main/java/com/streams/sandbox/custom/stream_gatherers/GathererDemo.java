package com.streams.sandbox.custom.stream_gatherers;

import java.util.*;
import java.util.stream.*;

public class GathererDemo {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        System.out.println("Chunked into pairs:");

        numbers.stream()
                .gather(new ChunkingGatherers<>(2))
                .forEach(System.out::println);

        // ---------------------------------------
        // Another example: running sum gatherer
        // ---------------------------------------

        System.out.println("\nRunning sum:");

        numbers.stream()
                .gather(new RunningSumGatherer())
                .forEach(System.out::println);
    }
}