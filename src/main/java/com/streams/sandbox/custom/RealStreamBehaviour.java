package com.streams.sandbox.custom;

import java.util.*;
import java.util.function.*;

class RealStreamBehaviour<T> {

    private final Supplier<Iterator<T>> source;

    private RealStreamBehaviour(Supplier<Iterator<T>> source) {
        this.source = source;
    }

    public static <T> RealStreamBehaviour<T> of(List<T> list) {
        return new RealStreamBehaviour<>(list::iterator);
    }

    public <R> RealStreamBehaviour<R> map(Function<T, R> mapper) {
        return new RealStreamBehaviour<>(() -> new Iterator<>() {

            private final Iterator<T> it = source.get();

            public boolean hasNext() {
                return it.hasNext();
            }

            public R next() {
                return mapper.apply(it.next());
            }
        });
    }

    public RealStreamBehaviour<T> filter(Predicate<T> predicate) {
        return new RealStreamBehaviour<>(() -> new Iterator<>() {

            private final Iterator<T> it = source.get();
            private T nextItem;
            private boolean hasCached = false;

            private void fetch() {
                while (it.hasNext()) {
                    T val = it.next();
                    if (predicate.test(val)) {
                        nextItem = val;
                        hasCached = true;
                        return;
                    }
                }
                hasCached = false;
            }

            public boolean hasNext() {
                if (!hasCached) fetch();
                return hasCached;
            }

            public T next() {
                if (!hasCached) fetch();
                hasCached = false;
                return nextItem;
            }
        });
    }

    public List<T> collect() {
        List<T> result = new ArrayList<>();
        Iterator<T> it = source.get();
        while (it.hasNext()) {
            result.add(it.next());
        }
        return result;
    }
}