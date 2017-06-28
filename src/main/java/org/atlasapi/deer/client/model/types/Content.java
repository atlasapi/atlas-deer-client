package org.atlasapi.deer.client.model.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.atlasapi.deer.client.model.Utils;

@JsonDeserialize(builder = Content.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {

    private final String id;
    private final String type;
    private final List<Alias> aliases;
    private final DisplayTitle displayTitle;
    private final Integer episodeNumber;
    private final Integer seriesNumber;
    private final String mediaType;
    private final String specialization;
    private final Source source;
    private final String title;
    private final String description;
    private final String image;
    private final String thumbnail;
    private final List<String> genres;
    private final String presentationChannel;
    private final String priority;
    private final String longDescription;
    private final Boolean blackAndWhite;
    private final List<String> countriesOfOrigin;
    private final Boolean scheduleOnly;
    private final List<Restriction> restrictions;
    private final List<String> certificates;
    private final List<String> languages;
    private final Container container;
    private final Series series;
    private final List<Broadcast> broadcasts;

    private Content(Builder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.aliases = Utils.immutableCopyOfOrEmpty(builder.aliases);
        this.displayTitle = builder.displayTitle;
        this.episodeNumber = builder.episodeNumber;
        this.seriesNumber = builder.seriesNumber;
        this.mediaType = builder.mediaType;
        this.specialization = builder.specialization;
        this.source = builder.source;
        this.title = builder.title;
        this.description = builder.description;
        this.image = builder.image;
        this.thumbnail = builder.thumbnail;
        this.genres = Utils.immutableCopyOfOrEmpty(builder.genres);
        this.presentationChannel = builder.presentationChannel;
        this.priority = builder.priority;
        this.longDescription = builder.longDescription;
        this.blackAndWhite = builder.blackAndWhite;
        this.countriesOfOrigin = Utils.immutableCopyOfOrEmpty(builder.countriesOfOrigin);
        this.scheduleOnly = builder.scheduleOnly;
        this.restrictions = Utils.immutableCopyOfOrEmpty(builder.restrictions);
        this.certificates = Utils.immutableCopyOfOrEmpty(builder.certificates);
        this.languages = Utils.immutableCopyOfOrEmpty(builder.languages);
        this.container = builder.container;
        this.series = builder.series;
        this.broadcasts = Utils.immutableCopyOfOrEmpty(builder.broadcasts);
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
    public List<Alias> getAliases() {
        return aliases;
    }

    @JsonProperty("display_title")
    public DisplayTitle getDisplayTitle() {
        return displayTitle;
    }

    @JsonProperty("episode_number")
    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    @JsonProperty("series_number")
    public Integer getSeriesNumber() {
        return seriesNumber;
    }

    @JsonProperty("media_type")
    public String getMediaType() {
        return mediaType;
    }

    @JsonProperty
    public String getSpecialization() {
        return specialization;
    }

    @JsonProperty
    public Source getSource() {
        return source;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public String getImage() {
        return image;
    }

    @JsonProperty
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty
    public List<String> getGenres() {
        return genres;
    }

    @JsonProperty("presentation_channel")
    public String getPresentationChannel() {
        return presentationChannel;
    }

    @JsonProperty
    public String getPriority() {
        return priority;
    }

    @JsonProperty("long_description")
    public String getLongDescription() {
        return longDescription;
    }

    @JsonProperty("black_and_white")
    public Boolean getBlackAndWhite() {
        return blackAndWhite;
    }

    @JsonProperty("countries_of_origin")
    public List<String> getCountriesOfOrigin() {
        return countriesOfOrigin;
    }

    @JsonProperty("schedule_only")
    public Boolean getScheduleOnly() {
        return scheduleOnly;
    }

    @JsonProperty
    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    @JsonProperty
    public List<String> getCertificates() {
        return certificates;
    }

    @JsonProperty
    public List<String> getLanguages() {
        return languages;
    }

    @JsonProperty
    public Container getContainer() {
        return container;
    }

    @JsonProperty
    public Series getSeries() {
        return series;
    }

    @JsonProperty
    public List<Broadcast> getBroadcasts() {
        return broadcasts;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String id;
        private String type;
        private List<Alias> aliases;
        private DisplayTitle displayTitle;
        private Integer episodeNumber;
        private Integer seriesNumber;
        private String mediaType;
        private String specialization;
        private Source source;
        private String title;
        private String description;
        private String image;
        private String thumbnail;
        private List<String> genres;
        private String presentationChannel;
        private String priority;
        private String longDescription;
        private Boolean blackAndWhite;
        private List<String> countriesOfOrigin;
        private Boolean scheduleOnly;
        private List<Restriction> restrictions;
        private List<String> certificates;
        private List<String> languages;
        private Container container;
        private Series series;
        private List<Broadcast> broadcasts;

        public Builder() {
        }

        @JsonProperty
        public Builder id(String val) {
            this.id = val;
            return this;
        }

        @JsonProperty
        public Builder type(String val) {
            this.type = val;
            return this;
        }

        @JsonProperty
        public Builder aliases(List<Alias> val) {
            this.aliases = val;
            return this;
        }

        @JsonProperty("display_title")
        public Builder displayTitle(DisplayTitle val) {
            this.displayTitle = val;
            return this;
        }

        @JsonProperty("episode_number")
        public Builder episodeNumber(Integer val) {
            this.episodeNumber = val;
            return this;
        }

        @JsonProperty("series_number")
        public Builder seriesNumber(Integer val) {
            this.seriesNumber = val;
            return this;
        }

        @JsonProperty
        public Builder specialization(String val) {
            this.specialization = val;
            return this;
        }

        @JsonProperty("media_type")
        public Builder mediaType(String val) {
            this.mediaType = val;
            return this;
        }

        @JsonProperty
        public Builder source(Source val) {
            this.source = val;
            return this;
        }

        @JsonProperty
        public Builder title(String val) {
            this.title = val;
            return this;
        }

        @JsonProperty
        public Builder description(String val) {
            this.description = val;
            return this;
        }

        @JsonProperty
        public Builder image(String val) {
            this.image = val;
            return this;
        }

        @JsonProperty
        public Builder thumbnail(String val) {
            this.thumbnail = val;
            return this;
        }

        @JsonProperty
        public Builder genres(List<String> val) {
            this.genres = val;
            return this;
        }

        @JsonProperty("presentation_channel")
        public Builder presentationChannel(String val) {
            this.presentationChannel = val;
            return this;
        }

        @JsonProperty
        public Builder priority(String val) {
            this.priority = val;
            return this;
        }

        @JsonProperty("long_description")
        public Builder longDescription(String val) {
            this.longDescription = val;
            return this;
        }

        @JsonProperty("black_and_white")
        public Builder blackAndWhite(Boolean val) {
            this.blackAndWhite = val;
            return this;
        }

        @JsonProperty("countries_of_origin")
        public Builder countriesOfOrigin(List<String> val) {
            this.countriesOfOrigin = val;
            return this;
        }

        @JsonProperty("schedule_only")
        public Builder scheduleOnly(Boolean val) {
            this.scheduleOnly = val;
            return this;
        }

        @JsonProperty
        public Builder restrictions(List<Restriction> val) {
            this.restrictions = val;
            return this;
        }

        @JsonProperty
        public Builder certificates(List<String> val) {
            this.certificates = val;
            return this;
        }

        @JsonProperty
        public Builder languages(List<String> val) {
            this.languages = val;
            return this;
        }

        @JsonProperty
        public Builder container(Container val) {
            this.container = val;
            return this;
        }

        @JsonProperty
        public Builder series(Series val) {
            this.series = val;
            return this;
        }

        @JsonProperty
        public Builder broadcasts(List<Broadcast> val) {
            this.broadcasts = val;
            return this;
        }

        public Content build() {
            return new Content(this);
        }
    }
}
