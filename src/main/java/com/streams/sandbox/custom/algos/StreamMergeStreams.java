package com.streams.sandbox.custom.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamMergeStreams {

    public static Stream<Integer> merge(
            List<Integer> a,
            List<Integer> b) {

        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a.size() && j < b.size()) {

            if (a.get(i) <= b.get(j)) {
                result.add(a.get(i++));
            } else {
                result.add(b.get(j++));
            }
        }

        while (i < a.size()) {
            result.add(a.get(i++));
        }

        while (j < b.size()) {
            result.add(b.get(j++));
        }

        return result.stream();
    }
}
