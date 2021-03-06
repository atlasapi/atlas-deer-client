package org.atlasapi.deer.client.uri;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Annotation {
    ID,
    REP_ID,
    IS_PUBLISHED,
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
    LOCATIONS,
    CUSTOM_FIELDS,
    ALL_MERGED_BROADCASTS,
    ALL_BROADCASTS,
    CHANNEL_GROUP_INFO,
    REGIONS,
    AWARDS,
    REVIEWS,
    RATINGS,
    LOCALIZED_TITLES,
    RELATED_LINKS,
    NO_CHANNEL_INFO,
    BROADCAST_CHANNEL,
    LOCATION_PROVIDERS,
    LCN_SHARING,
    IMAGES,
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
