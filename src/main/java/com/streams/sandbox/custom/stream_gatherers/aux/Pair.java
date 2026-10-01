package com.streams.sandbox.custom.stream_gatherers.aux;
import java.util.List;

public record Pair<T>(List<T> values) {
    @Override
    public String toString() {
        return values.toString();
    }
}
