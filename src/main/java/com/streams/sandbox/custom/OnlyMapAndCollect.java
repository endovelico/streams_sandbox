package com.streams.sandbox.custom;

import java.util.*;
import java.util.function.*;

class OnlyMapAndCollect<T> {

    private final List<T> source;

    private OnlyMapAndCollect(List<T> source) {
        this.source = source;
    }

    public static <T> OnlyMapAndCollect<T> of(List<T> source) {
        return new OnlyMapAndCollect<>(source);
    }

    public <R> OnlyMapAndCollect<R> map(Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T item : source) {
            result.add(mapper.apply(item));
        }
        return new OnlyMapAndCollect<>(result);
    }

    public List<T> collect() {
        return source;
    }
}
