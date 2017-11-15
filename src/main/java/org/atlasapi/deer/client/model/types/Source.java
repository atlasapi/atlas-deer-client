package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Source.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Source {

    private final String key;
    private final String name;
    private final String country;

    private Source(Builder builder) {
        this.key = builder.key;
        this.name = builder.name;
        this.country = builder.country;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private String key;
        private String name;
        private String country;

        public Builder() { }

        public Builder withKey(String key) {
            this.key = key;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Source build() {
            return new Source(this);
        }
    }

}
