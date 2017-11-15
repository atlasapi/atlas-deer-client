package org.atlasapi.deer.client.model.types;

import java.io.IOException;
import java.util.List;

import org.atlasapi.deer.client.model.Utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableList;

@JsonDeserialize(builder = Content.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Content {

    private final String id;
    private final String type;
    private final List<Alias> aliases;
    private final List<SameAs> sameAs;
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
    private final List<Certificate> certificates;
    private final List<Language> languages;
    private final List<ReleaseDate> releaseDates;
    private final Container container;
    private final List<Series> series;
    private final List<SubItem> content;
    private final List<SubItemSummary> subItemSummaries;
    private final List<Broadcast> broadcasts;
    private final List<Person> people;

    private Content(Builder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.aliases = Utils.immutableCopyOfOrEmpty(builder.aliases);
        this.sameAs = Utils.immutableCopyOfOrEmpty(builder.sameAs);
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
        this.releaseDates = Utils.immutableCopyOfOrEmpty(builder.releaseDates);
        this.container = builder.container;
        this.series = Utils.immutableCopyOfOrEmpty(builder.series);
        this.content = Utils.immutableCopyOfOrEmpty(builder.content);
        this.subItemSummaries = Utils.immutableCopyOfOrEmpty(builder.subItemSummaries);
        this.broadcasts = Utils.immutableCopyOfOrEmpty(builder.broadcasts);
        this.people = Utils.immutableCopyOfOrEmpty(builder.people);
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

    public List<SameAs> getSameAs() {
        return sameAs;
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

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public List<ReleaseDate> getReleaseDates() {
        return releaseDates;
    }

    public Container getContainer() {
        return container;
    }

    public List<Series> getSeries() {
        return series;
    }

    public List<SubItem> getContent() {
        return content;
    }

    public List<SubItemSummary> getSubItemSummaries() {
        return subItemSummaries;
    }

    public List<Broadcast> getBroadcasts() {
        return broadcasts;
    }

    public List<Person> getPeople() {
        return people;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String id;
        private String type;
        private List<Alias> aliases;
        private List<SameAs> sameAs;
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
        private List<Certificate> certificates;
        private List<Language> languages;
        private List<ReleaseDate> releaseDates;
        private Container container;
        private List<Series> series;
        private List<SubItem> content;
        private List<SubItemSummary> subItemSummaries;
        private List<Broadcast> broadcasts;
        private List<Person> people;

        public Builder() {
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withAliases(List<Alias> aliases) {
            this.aliases = aliases;
            return this;
        }

        public Builder withSameAs(List<SameAs> sameAs) {
            this.sameAs = sameAs;
            return this;
        }
        public Builder withDisplayTitle(DisplayTitle displayTitle) {
            this.displayTitle = displayTitle;
            return this;
        }

        public Builder withEpisodeNumber(Integer episodeNumber) {
            this.episodeNumber = episodeNumber;
            return this;
        }

        public Builder withSeriesNumber(Integer seriesNumber) {
            this.seriesNumber = seriesNumber;
            return this;
        }

        public Builder withSpecialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public Builder withMediaType(String mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public Builder withSource(Source source) {
            this.source = source;
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

        public Builder withImage(String image) {
            this.image = image;
            return this;
        }

        public Builder withThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder withGenres(List<String> genres) {
            this.genres = genres;
            return this;
        }

        public Builder withPresentationChannel(String presentationChannel) {
            this.presentationChannel = presentationChannel;
            return this;
        }

        public Builder withPriority(String priority) {
            this.priority = priority;
            return this;
        }

        public Builder withLongDescription(String longDescription) {
            this.longDescription = longDescription;
            return this;
        }

        public Builder withBlackAndWhite(Boolean blackAndWhite) {
            this.blackAndWhite = blackAndWhite;
            return this;
        }

        public Builder withCountriesOfOrigin(List<String> countriesOfOrigin) {
            this.countriesOfOrigin = countriesOfOrigin;
            return this;
        }

        public Builder withScheduleOnly(Boolean scheduleOnly) {
            this.scheduleOnly = scheduleOnly;
            return this;
        }

        public Builder withRestrictions(List<Restriction> restrictions) {
            this.restrictions = restrictions;
            return this;
        }

        public Builder withCertificates(List<Certificate> certificates) {
            this.certificates = certificates;
            return this;
        }

        public Builder withLanguages(List<Language> languages) {
            this.languages = languages;
            return this;
        }

        public Builder withReleaseDates(List<ReleaseDate> releaseDates) {
            this.releaseDates = releaseDates;
            return this;
        }

        public Builder withContainer(Container container) {
            this.container = container;
            return this;
        }

        // episode has series singular
        @JsonIgnore
        public Builder withSeries(Series series) {
            this.series = series == null ? null : ImmutableList.of(series);
            return this;
        }

        // brand has series plural
        @JsonDeserialize(using = SeriesDeserializer.class)
        public Builder withSeries(List<Series> series) {
            this.series = series;
            return this;
        }

        public Builder withContent(List<SubItem> content) {
            this.content = content;
            return this;
        }

        public Builder withSubItemSummaries(List<SubItemSummary> subItemSummaries) {
            this.subItemSummaries = subItemSummaries;
            return this;
        }

        public Builder withBroadcasts(List<Broadcast> broadcasts) {
            this.broadcasts = broadcasts;
            return this;
        }

        public Builder withPeople(List<Person> people) {
            this.people = people;
            return this;
        }

        public Content build() {
            return new Content(this);
        }


        protected static class SeriesDeserializer extends JsonDeserializer<List<Series>> {
            @Override public List<Series> deserialize(
                    JsonParser jsonParser,
                    DeserializationContext deserializationContext
            ) throws IOException {
                switch (jsonParser.currentToken()) {
                case START_ARRAY:
                    ImmutableList.Builder<Series> builder = ImmutableList.builder();
                    jsonParser.nextToken();
                    builder.addAll(jsonParser.readValuesAs(Series.class));
                    return builder.build();
                default:
                    return ImmutableList.of(jsonParser.readValueAs(Series.class));
                }
            }
        }
    }
}
