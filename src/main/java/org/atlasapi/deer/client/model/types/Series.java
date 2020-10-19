package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Series.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Series {

    private final String id;
    private final Content.Type type;
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

    public String getId() {
        return id;
    }

    public Content.Type getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getSeriesNumber() {
        return seriesNumber;
    }

    public Integer getTotalEpisodes() {
        return totalEpisodes;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private String id;
        private Content.Type type = Content.Type.SERIES;
        private String title;
        private String description;
        private Integer seriesNumber;
        private Integer totalEpisodes;

        public Builder() {}

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withType(Content.Type type) {
            this.type = type;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withSeriesNumber(Integer seriesNumber) {
            this.seriesNumber = seriesNumber;
            return this;
        }

        public Builder withTotalEpisodes(Integer totalEpisodes) {
            this.totalEpisodes = totalEpisodes;
            return this;
        }

        public Series build() {
            return new Series(this);
        }
    }
}
