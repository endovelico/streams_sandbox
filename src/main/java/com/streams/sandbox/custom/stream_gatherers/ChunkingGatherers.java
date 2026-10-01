package com.streams.sandbox.custom.stream_gatherers;

import com.streams.sandbox.custom.stream_gatherers.aux.Pair;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Gatherer;

public class ChunkingGatherers<T> implements Gatherer<T, List<T>, Pair<T>> {

    private final int size;

    public ChunkingGatherers(int size) {
        this.size = size;
    }

    // 1. Create initial state
    @Override
    public Supplier<List<T>> initializer() {
        return ArrayList::new;
    }

    // 2. Process each element
    @Override
    public Integrator<List<T>, T, Pair<T>> integrator() {
        return (state, element, downstream) -> {

            state.add(element);

            if (state.size() == size) {
                downstream.push(new Pair<>(List.copyOf(state)));
                state.clear();
            }

            return true; // continue
        };
    }

    // 3. Final flush
    @Override
    public BiConsumer<List<T>, Downstream<? super Pair<T>>> finisher() {
        return (state, downstream) -> {
            if (!state.isEmpty()) {
                downstream.push(new Pair<>(List.copyOf(state)));
            }
        };
    }
}
