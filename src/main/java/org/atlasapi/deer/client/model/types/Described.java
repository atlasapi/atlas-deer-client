package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.atlasapi.deer.client.model.Utils;

import java.util.List;

@JsonDeserialize(builder = Described.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public abstract class Described extends Identified{

    private String title;
    private String description;
    private String longDescription;
    private String mediaType;
    private String specialization;
    private List<String> genres;
    private Source source;
    private String image;
    private String thumbnail;
    private Boolean scheduleOnly;
    private String presentationChannel;
    private String priority;

    protected Described(Builder builder) {
        super(builder);
        this.title = builder.title;
        this.description = builder.description;
        this.longDescription = builder.longDescription;
        this.mediaType = builder.mediaType;
        this.specialization = builder.specialization;
        this.genres = Utils.immutableCopyOfOrEmpty(builder.genres);
        this.source = builder.source;
        this.image = builder.image;
        this.thumbnail = builder.thumbnail;
        this.scheduleOnly = builder.scheduleOnly;
        this.presentationChannel = builder.presentationChannel;
        this.priority = builder.priority;
    }

    public static Builder<?> builder(Described described) {
        return ((Builder<?>) Identified.builder(described))
                .withTitle(described.title)
                .withDescription(described.description)
                .withLongDescription(described.longDescription)
                .withMediaType(described.mediaType)
                .withSpecialization(described.specialization)
                .withGenres(described.genres)
                .withSource(described.source)
                .withImage(described.image)
                .withThumbnail(described.thumbnail)
                .withScheduleOnly(described.scheduleOnly)
                .withPresentationChannel(described.presentationChannel)
                .withPriority(described.priority);
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Source getSource() {
        return source;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getPresentationChannel() {
        return presentationChannel;
    }

    public String getPriority() {
        return priority;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public Boolean getScheduleOnly() {
        return scheduleOnly;
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @SuppressWarnings("unchecked")
    public static class Builder<B extends Builder<B>> extends Identified.Builder<B> {
        private String title;
        private String description;
        private String longDescription;
        private String mediaType;
        private String specialization;
        private List<String> genres;
        private Source source;
        private String image;
        private String thumbnail;
        private Boolean scheduleOnly;
        private String presentationChannel;
        private String priority;

        public B withTitle(String val) {
            title = val;
            return (B) this;
        }

        public B withDescription(String val) {
            description = val;
            return (B) this;
        }

        public B withLongDescription(String val) {
            longDescription = val;
            return (B) this;
        }

        public B withMediaType(String val) {
            mediaType = val;
            return (B) this;
        }

        public B withSpecialization(String val) {
            specialization = val;
            return (B) this;
        }

        public B withGenres(List<String> val) {
            genres = val;
            return (B) this;
        }

        public B withSource(Source val) {
            source = val;
            return (B) this;
        }

        public B withImage(String val) {
            image = val;
            return (B) this;
        }

        public B withThumbnail(String val) {
            thumbnail = val;
            return (B) this;
        }

        public B withScheduleOnly(boolean val) {
            scheduleOnly = val;
            return (B) this;
        }

        public B withPresentationChannel(String val) {
            presentationChannel = val;
            return (B) this;
        }

        public B withPriority(String val) {
            priority = val;
            return (B) this;
        }
    }

}
