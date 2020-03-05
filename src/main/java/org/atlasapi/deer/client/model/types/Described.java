package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.atlasapi.deer.client.model.Utils;

import java.util.List;
import java.util.Set;

@JsonDeserialize(builder = Described.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public abstract class Described extends Identified {

    private String title;
    private Set<LocalizedTitle> titles;
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
    private Boolean isPublished;
    private Set<RelatedLink> relatedLinks;

    protected Described(Builder builder) {
        super(builder);
        this.title = builder.title;
        this.titles = Utils.immutableCopyOfOrEmpty(builder.titles);
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
        this.isPublished = builder.isPublished;
        this.relatedLinks = Utils.immutableCopyOfOrEmpty(builder.relatedLinks);
    }

    protected static Builder<?> builder(Described described) {
        return builder(described, new Builder());
    }

    protected static <B extends Builder<B>> B builder(Described described, B builder) {
        return Identified.builder(described, builder)
                .withTitle(described.title)
                .withTitles(described.titles)
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
                .withPriority(described.priority)
                .withIsPublished(described.isPublished)
                .withRelatedLinks(described.relatedLinks);
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

    public Set<LocalizedTitle> getTitles() {
        return titles;
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

    public Boolean getIsPublished() {
        return isPublished;
    }

    public Set<RelatedLink> getRelatedLinks() {
        return relatedLinks;
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @SuppressWarnings("unchecked")
    public static class Builder<B extends Builder<B>> extends Identified.Builder<B> {

        private String title;
        private Set<LocalizedTitle> titles;
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
        private Boolean isPublished;
        private Set<RelatedLink> relatedLinks;

        public B withTitle(String val) {
            title = val;
            return (B) this;
        }

        public B withTitles(Set<LocalizedTitle> val) {
            titles = val;
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

        public B withScheduleOnly(Boolean val) {
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

        public B withIsPublished(Boolean val) {
            isPublished = val;
            return (B) this;
        }

        public B withRelatedLinks(Set<RelatedLink> val) {
            relatedLinks = val;
            return (B) this;
        }
    }

}
