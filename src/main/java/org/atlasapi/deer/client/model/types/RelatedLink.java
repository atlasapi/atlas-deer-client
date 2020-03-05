package org.atlasapi.deer.client.model.types;

import javax.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = RelatedLink.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelatedLink {

    private LinkType type;
    private String url;

    private String sourceId;
    private String shortName;
    private String title;
    private String description;
    private String image;
    private String thumbnail;

    private RelatedLink(Builder builder) {
        type = builder.type;
        url = builder.url;
        sourceId = builder.sourceId;
        shortName = builder.shortName;
        title = builder.title;
        description = builder.description;
        image = builder.image;
        thumbnail = builder.thumbnail;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public LinkType getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    @Nullable
    public String getSourceId() {
        return sourceId;
    }

    @Nullable
    public String getShortName() {
        return shortName;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Nullable
    public String getImage() {
        return image;
    }

    @Nullable
    public String getThumbnail() {
        return thumbnail;
    }

    public enum LinkType {
        FACEBOOK,
        TWITTER,
        FLICKR,
        SIMULCAST,
        ARTICLE,
        VOD,
        UNKNOWN,
        ;
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {

        private LinkType type;
        private String url;
        private String sourceId;
        private String shortName;
        private String title;
        private String description;
        private String image;
        private String thumbnail;

        private Builder() {
        }

        public Builder withType(LinkType type) {
            this.type = type;
            return this;
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withSourceId(@Nullable String sourceId) {
            this.sourceId = sourceId;
            return this;
        }

        public Builder withShortName(@Nullable String shortName) {
            this.shortName = shortName;
            return this;
        }

        public Builder withTitle(@Nullable String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(@Nullable String description) {
            this.description = description;
            return this;
        }

        public Builder withImage(@Nullable String image) {
            this.image = image;
            return this;
        }

        public Builder withThumbnail(@Nullable String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public RelatedLink build() {
            return new RelatedLink(this);
        }
    }
}
