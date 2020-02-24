package org.atlasapi.deer.client.model.types;

import java.util.Arrays;

import javax.annotation.Nullable;

import com.google.common.base.Strings;

public enum ReviewType {
    NORMAL_REVIEW,
    SHORT_REVIEW,
    FOTD_REVIEW;

    public String toKey() {
        return this.name().toLowerCase();
    }

    @Nullable
    public static ReviewType fromKey(@Nullable String key) {
        if (Strings.isNullOrEmpty(key)) {
            return null;
        }

        return Arrays.stream(ReviewType.values())
                .filter(reviewType -> reviewType.name().equalsIgnoreCase(key))
                .findFirst().orElse(null);
    }
}
