package org.atlasapi.deer.client.model.types;

import java.util.List;

import com.google.api.client.util.Key;


public class Content {

    @Key
    private String id;

    @Key
    private String type;

    @Key
    private List<Alias> aliases;

    @Key("display_title")
    private DisplayTitle displayTitle;

    @Key("episode_number")
    private Integer episodeNumber;

    @Key("series_number")
    private Integer seriesNumber;

    @Key("media_type")
    private String mediaType;

    @Key
    private String specialization;

    @Key
    private Source source;

    @Key
    private String title;

    @Key
    private String description;

    @Key
    private String image;

    @Key
    private String thumbnail;

    @Key
    private List<String> genres;

    @Key("presentation_channel")
    private String presentationChannel;

    @Key
    private String priority;

    @Key("long_description")
    private String longDescription;

    @Key("black_and_white")
    private Boolean blackAndWhite;

    @Key("countries_of_origin")
    private List<String> countriesOfOrigin;

    @Key("schedule_only")
    private Boolean scheduleOnly;

    @Key
    private List<Restriction> restrictions;

    @Key
    private List<String> certificates;

    @Key
    private List<String> languages;

    @Key
    private Container container;

    @Key
    private Series series;

    @Key
    private List<Broadcast> broadcasts;

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
        this.aliases = aliases;
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
        this.genres = genres;
        this.presentationChannel = presentationChannel;
        this.priority = priority;
        this.longDescription = longDescription;
        this.blackAndWhite = blackAndWhite;
        this.countriesOfOrigin = countriesOfOrigin;
        this.scheduleOnly = scheduleOnly;
        this.restrictions = restrictions;
        this.certificates = certificates;
        this.languages = languages;
        this.container = container;
        this.series = series;
        this.broadcasts = broadcasts;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public List<Alias> getAliases() {
        return aliases;
    }

    public DisplayTitle getDisplayTitle() {
        return displayTitle;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public Integer getSeriesNumber() {
        return seriesNumber;
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

    public Boolean getBlackAndWhite() {
        return blackAndWhite;
    }

    public List<String> getCountriesOfOrigin() {
        return countriesOfOrigin;
    }

    public Boolean getScheduleOnly() {
        return scheduleOnly;
    }

    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    public List<String> getCertificates() {
        return certificates;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public Container getContainer() {
        return container;
    }

    public Series getSeries() {
        return series;
    }

    public List<Broadcast> getBroadcasts() {
        return broadcasts;
    }

    public static Builder builder() {
        return new Builder();
    }

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
