package org.atlasapi.deer.client.uri;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public enum Annotation {
    ID,
    EXTENDED_ID,
    DESCRIPTION,
    EXTENDED_DESCRIPTION,
    BROADCASTS,
    PARENT,
    CHANNEL,
    CHANNELS,
    CHANNEL_SUMMARY,
    PUBLISHER,
    SUB_ITEMS,
    SUB_ITEM_SUMMARIES,
    AUDIT,
    BRAND_REFERENCE,
    BRAND_SUMMARY,
    SERIES,
    SERIES_REFERENCE,
    SERIES_SUMMARY,
    NON_MERGED
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
