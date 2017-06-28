package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Series.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Series {

    private final String id;
    private final String type;
    private final String title;
    private final String description;
    private final Integer seriesNumber;
    private final Integer totalEpisodes;

    private Series(Builder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.title = builder.title;
        this.description = builder.description;
        this.seriesNumber = builder.seriesNumber;
        this.totalEpisodes = builder.totalEpisodes;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public String getType() {
        return type;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty("series_number")
    public Integer getSeriesNumber() {
        return seriesNumber;
    }

    @JsonProperty("total_episodes")
    public Integer getTotalEpisodes() {
        return totalEpisodes;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private String id;
        private String type;
        private String title;
        private String description;
        private Integer seriesNumber;
        private Integer totalEpisodes;

        public Builder() {}

        @JsonProperty
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        @JsonProperty
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        @JsonProperty
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        @JsonProperty
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        @JsonProperty("series_number")
        public Builder seriesNumber(Integer seriesNumber) {
            this.seriesNumber = seriesNumber;
            return this;
        }

        @JsonProperty("total_episodes")
        public Builder totalEpisodes(Integer totalEpisodes) {
            this.totalEpisodes = totalEpisodes;
            return this;
        }

        public Series build() {
            return new Series(this);
        }
    }
}
