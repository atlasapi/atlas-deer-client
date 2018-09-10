package org.atlasapi.deer.client.uri;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Annotation {
    ID,
    EXTENDED_ID,
    DESCRIPTION,
    EXTENDED_DESCRIPTION,
    BRAND_REFERENCE,
    BRAND_SUMMARY,
    SERIES_REFERENCE,
    SERIES_SUMMARY,
    SUB_ITEMS,
    SUB_ITEM_SUMMARIES,
    PEOPLE,
    BROADCASTS,
    CHANNEL,
    PARENT,
    CHANNELS,
    CHANNEL_SUMMARY,
    PUBLISHER,
    SERIES,
    AUDIT,
    NON_MERGED,
    CONTENT_DETAIL,
    TAGS,
    MODIFIED_DATES,
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
