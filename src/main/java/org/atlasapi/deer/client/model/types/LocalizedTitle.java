package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = LocalizedTitle.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalizedTitle extends Localized {

    private String value;

    private LocalizedTitle(Builder builder) {
        super(builder);
        value = builder.value;
    }

    public static Builder<?> builder(LocalizedTitle localizedTitle) {
        return builder(localizedTitle, new Builder());
    }

    public String getValue() {
        return value;
    }

    protected static <B extends Builder<B>> B builder (LocalizedTitle localizedTitle, B builder) {
        return Localized.builder(localizedTitle, builder)
                .withValue(localizedTitle.value);
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder<B extends Builder<B>> extends Localized.Builder<B> {

        private String value;

        private Builder() {
        }

        public B withValue(String value) {
            this.value = value;
            return (B) this;
        }

        public LocalizedTitle build() {
            return new LocalizedTitle(this);
        }
    }
}
