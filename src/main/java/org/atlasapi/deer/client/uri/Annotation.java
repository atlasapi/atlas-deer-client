package org.atlasapi.deer.client.uri;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public enum Annotation {
    DESCRIPTION,
    BROADCASTS,
    CHANNEL,
    PUBLISHER,
    SUB_ITEMS,
    AUDIT
    ;

    private static final BiMap<String, Annotation> LOOKUP =
            HashBiMap.create(
                    Arrays.stream(values())
                            .collect(Collectors.toMap(
                                    Annotation::toKey,
                                    value -> value
                            ))
            );

    public static BiMap<String, Annotation> lookup() {
        return LOOKUP;
    }

    public String toKey() {
        return this.name().toLowerCase();
    }
}
