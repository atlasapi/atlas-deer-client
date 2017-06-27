package org.atlasapi.deer.client.model.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableList;
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

    private Content(
            String id,
            String type,
            List<Alias> aliases,
            DisplayTitle displayTitle,
            Integer episodeNumber,
            Integer seriesNumber,
            String mediaType,
            String specialization,
            Source source,
            String title,
            String description,
            String image,
            String thumbnail,
            List<String> genres,
            String presentationChannel,
            String priority,
            String longDescription,
            Boolean blackAndWhite,
            List<String> countriesOfOrigin,
            Boolean scheduleOnly,
            List<Restriction> restrictions,
            List<String> certificates,
            List<String> languages,
            Container container,
            Series series,
            List<Broadcast> broadcasts
    ) {
        this.id = id;
        this.type = type;
        this.aliases = Utils.immutableCopyOfOrEmpty(aliases);
        this.displayTitle = displayTitle;
        this.episodeNumber = episodeNumber;
        this.seriesNumber = seriesNumber;
        this.mediaType = mediaType;
        this.specialization = specialization;
        this.source = source;
        this.title = title;
        this.description = description;
        this.image = image;
        this.thumbnail = thumbnail;
        this.genres = Utils.immutableCopyOfOrEmpty(genres);
        this.presentationChannel = presentationChannel;
        this.priority = priority;
        this.longDescription = longDescription;
        this.blackAndWhite = blackAndWhite;
        this.countriesOfOrigin = Utils.immutableCopyOfOrEmpty(countriesOfOrigin);
        this.scheduleOnly = scheduleOnly;
        this.restrictions = Utils.immutableCopyOfOrEmpty(restrictions);
        this.certificates = Utils.immutableCopyOfOrEmpty(certificates);
        this.languages = Utils.immutableCopyOfOrEmpty(languages);
        this.container = container;
        this.series = series;
        this.broadcasts = Utils.immutableCopyOfOrEmpty(broadcasts);
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

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder type(String val) {
            type = val;
            return this;
        }

        public Builder aliases(List<Alias> val) {
            aliases = val;
            return this;
        }

        public Builder displayTitle(DisplayTitle val) {
            displayTitle = val;
            return this;
        }

        public Builder episodeNumber(Integer val) {
            episodeNumber = val;
            return this;
        }

        public Builder seriesNumber(Integer val) {
            seriesNumber = val;
            return this;
        }

        public Builder specialization(String val) {
            specialization = val;
            return this;
        }

        public Builder mediaType(String val) {
            mediaType = val;
            return this;
        }

        public Builder source(Source val) {
            source = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder image(String val) {
            image = val;
            return this;
        }

        public Builder thumbnail(String val) {
            thumbnail = val;
            return this;
        }

        public Builder genres(List<String> val) {
            genres = val;
            return this;
        }

        public Builder presentationChannel(String val) {
            presentationChannel = val;
            return this;
        }

        public Builder priority(String val) {
            priority = val;
            return this;
        }

        public Builder longDescription(String val) {
            longDescription = val;
            return this;
        }

        public Builder blackAndWhite(Boolean val) {
            blackAndWhite = val;
            return this;
        }

        public Builder countriesOfOrigin(List<String> val) {
            countriesOfOrigin = val;
            return this;
        }

        public Builder scheduleOnly(Boolean val) {
            scheduleOnly = val;
            return this;
        }

        public Builder restrictions(List<Restriction> val) {
            restrictions = val;
            return this;
        }

        public Builder certificates(List<String> val) {
            certificates = val;
            return this;
        }

        public Builder languages(List<String> val) {
            languages = val;
            return this;
        }

        public Builder container(Container val) {
            container = val;
            return this;
        }

        public Builder series(Series val) {
            series = val;
            return this;
        }

        public Builder broadcasts(List<Broadcast> val) {
            broadcasts = val;
            return this;
        }

        public Content build() {
            return new Content(
                    id, type, aliases, displayTitle, episodeNumber, seriesNumber, mediaType,
                    specialization, source, title, description, image, thumbnail, genres,
                    presentationChannel, priority, longDescription, blackAndWhite,
                    countriesOfOrigin, scheduleOnly, restrictions, certificates, languages,
                    container, series, broadcasts
            );
        }
    }
}
