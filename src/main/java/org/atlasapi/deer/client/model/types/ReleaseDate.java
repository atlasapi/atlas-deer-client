package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ReleaseDate.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDate {

    private final String releaseDate;
    private final String country;
    private final String type;

    private ReleaseDate(Builder builder) {
        this.releaseDate = builder.releaseDate;
        this.country = builder.country;
        this.type = builder.type;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getCountry() {
        return country;
    }

    public String getType() {
        return type;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private String releaseDate;
        private String country;
        private String type;

        public Builder() { }

        public Builder releaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public ReleaseDate build() {
            return new ReleaseDate(this);
        }
    }
}
