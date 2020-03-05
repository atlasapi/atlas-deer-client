package org.atlasapi.deer.client.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

public abstract class Utils {

    public static <T> ImmutableList<T> immutableCopyOfOrEmpty(@Nullable List<T> list) {
        return list == null ? ImmutableList.of() : ImmutableList.copyOf(list);
    }

    public static <T>ImmutableSet<T> immutableCopyOfOrEmpty(@Nullable Set<T> set) {
        return set == null ? ImmutableSet.of() : ImmutableSet.copyOf(set);
    }

    public static <K, V> ImmutableMap<K, V> immutableCopyOfOrEmpty(@Nullable Map<K, V> map) {
        return map == null ? ImmutableMap.of() : ImmutableMap.copyOf(map);
    }

    public static <T> T getFirst(Iterable<T> iterable) {
        if (iterable == null) {
            return null;
        }
        return Iterables.getFirst(iterable, null);
    }
}
