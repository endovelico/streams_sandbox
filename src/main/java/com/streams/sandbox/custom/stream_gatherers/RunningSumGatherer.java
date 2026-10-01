package com.streams.sandbox.custom.stream_gatherers;

import java.util.function.Supplier;
import java.util.stream.Gatherer;

public class RunningSumGatherer implements Gatherer<Integer, int[], Integer> {

    @Override
    public Supplier<int[]> initializer() {
        return () -> new int[]{0}; // mutable state
    }

    @Override
    public Integrator<int[], Integer, Integer> integrator() {
        return (state, element, downstream) -> {
            state[0] += element;
            downstream.push(state[0]);
            return true;
        };
    }
}
