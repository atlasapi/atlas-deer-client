package org.atlasapi.deer.client.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public abstract class Utils {

    public static <T> ImmutableList<T> immutableCopyOfOrEmpty(@Nullable List<T> list) {
        return list == null ? ImmutableList.of() : ImmutableList.copyOf(list);
    }

    public static <K, V> ImmutableMap<K, V> immutableCopyOfOrEmpty(@Nullable Map<K, V> map) {
        return map == null ? ImmutableMap.of() : ImmutableMap.copyOf(map);
    }

}
