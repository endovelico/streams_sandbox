package com.streams.sandbox.custom;

import java.util.*;
import java.util.function.*;

public class MapCollectAndFilter<T> {

    private final List<T> source;

    private MapCollectAndFilter(List<T> source) {
        this.source = source;
    }

    public static <T> MapCollectAndFilter<T> of(List<T> source) {
        return new MapCollectAndFilter<>(source);
    }

    public <R> MapCollectAndFilter<R> map(Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : source) {
            result.add(mapper.apply(item));
        }
        return new MapCollectAndFilter<>(result);
    }

    public MapCollectAndFilter<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : source) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return new MapCollectAndFilter<>(result);
    }

    public List<T> collect() {
        return source;
    }
}
