package org.atlasapi.deer.client.model.types;

import java.util.Locale;

import javax.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Localized.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Localized {

    private Locale locale;

    public Localized(Builder builder) {
        locale = (builder.locale == null)
                 ? null
                 : Locale.forLanguageTag(builder.locale);
    }

    @Nullable
    public Locale getLocale() {
        return locale;
    }

    public static Builder<?> builder(Localized localized)
    {
        return builder(localized, new Builder());
    }

    protected static <B extends Builder<B>> B builder(Localized localized, B builder) {
        return builder
                .withLocale(localized.locale.toLanguageTag())
                ;
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder<B extends Builder<B>> {

        private String locale;

        public B withLocale(@Nullable String locale) {
            this.locale = locale;
            return (B) this;
        }

    }
}
