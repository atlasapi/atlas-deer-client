package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = SubItemSummary.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SubItemSummary {

    private final SubItem item;
    private final String title;
    private final String description;
    private final String image;
    private final Integer episodeNumber;

    @JsonCreator
    public SubItemSummary(Builder builder) {
        this.item = builder.item;
        this.title = builder.title;
        this.description = builder.description;
        this.image = builder.image;
        this.episodeNumber = builder.episodeNumber;
    }

    public SubItem getItem() {
        return item;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private SubItem item;
        private String title;
        private String description;
        private String image;
        private Integer episodeNumber;

        public Builder() { }

        public Builder item(SubItem item) {
            this.item = item;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Builder episodeNumber(Integer episodeNumber) {
            this.episodeNumber = episodeNumber;
            return this;
        }

        public SubItemSummary build() {
            return new SubItemSummary(this);
        }
    }
}
