package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.base.Strings;
import com.metabroadcast.common.media.MimeType;

import java.time.Instant;

@JsonDeserialize(builder = Image.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    private final String uri;
    private final MimeType mimeType;
    private final String type;
    private final String color;
    private final String theme;
    private final String aspectRatio;
    private final Instant availabilityStart;
    private final Instant availabilityEnd;
    private final Integer width;
    private final Integer height;
    private final Boolean hasTitleArt;
    private final Source source;

    private Image(Builder builder) {
        uri = builder.uri;
        mimeType = !Strings.isNullOrEmpty(builder.mimeType) ? MimeType.fromString(builder.mimeType) : null;
        type = builder.type;
        color = builder.color;
        theme = builder.theme;
        aspectRatio = builder.aspectRatio;
        availabilityStart = builder.availabilityStart;
        availabilityEnd = builder.availabilityEnd;
        width = builder.width;
        height = builder.height;
        hasTitleArt = builder.hasTitleArt;
        source = builder.source;
    }

    public String getUri() {
        return uri;
    }

    @JsonIgnore
    public MimeType getMimeType() {
        return mimeType;
    }

    @JsonProperty("mime_type")
    public String getMimeTypeAsString() {
        return mimeType.toString();
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getTheme() {
        return theme;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public Instant getAvailabilityStart() {
        return availabilityStart;
    }

    public Instant getAvailabilityEnd() {
        return availabilityEnd;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Boolean getHasTitleArt() {
        return hasTitleArt;
    }

    public Source getSource() {
        return source;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String uri;
        private String mimeType;
        private String type;
        private String color;
        private String theme;
        private String aspectRatio;
        private Instant availabilityStart;
        private Instant availabilityEnd;
        private Integer width;
        private Integer height;
        private Boolean hasTitleArt;
        private Source source;

        private Builder() {
        }

        public Builder withUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder withMimeType(String mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Builder withTheme(String theme) {
            this.theme = theme;
            return this;
        }

        public Builder withAspectRatio(String aspectRatio) {
            this.aspectRatio = aspectRatio;
            return this;
        }

        public Builder withAvailabilityStart(Instant availabilityStart) {
            this.availabilityStart = availabilityStart;
            return this;
        }

        public Builder withAvailabilityEnd(Instant availabilityEnd) {
            this.availabilityEnd = availabilityEnd;
            return this;
        }

        public Builder withWidth(Integer width) {
            this.width = width;
            return this;
        }

        public Builder withHeight(Integer height) {
            this.height = height;
            return this;
        }

        @JsonProperty("hasTitleArt")
        public Builder withHasTitleArt(Boolean hasTitleArt) {
            this.hasTitleArt = hasTitleArt;
            return this;
        }

        public Builder withSource(Source source) {
            this.source = source;
            return this;
        }

        public Image build() {
            return new Image(this);
        }
    }
}
