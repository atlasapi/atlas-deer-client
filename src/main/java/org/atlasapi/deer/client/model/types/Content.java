package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.google.common.collect.ImmutableList;
import org.atlasapi.deer.client.model.Utils;

import java.io.IOException;
import java.util.List;

@JsonDeserialize(builder = Content.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Content extends Described {

    private final Type type;
    private final DisplayTitle displayTitle;
    private final Integer episodeNumber;
    private final Integer seriesNumber;
    private final Integer totalEpisodes;
    private final Boolean blackAndWhite;
    private final List<String> countriesOfOrigin;
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
    private final List<Tag> tags;
    private final Integer year;

    @JsonSerialize(using = ToStringSerializer.class)
    public enum Type {

        BRAND,
        SERIES,
        ITEM,
        EPISODE,
        FILM,
        SONG,
        CLIP;

        private final String str = name().toLowerCase();

        @Override
        public String toString() {
            return str;
        }

        @JsonCreator
        public static Type fromString(String str) {
            return valueOf(str.toUpperCase());
        }

    }

    private Content(Builder builder) {
        super(builder);
        this.type = builder.type;
        this.displayTitle = builder.displayTitle;
        this.episodeNumber = builder.episodeNumber;
        this.seriesNumber = builder.seriesNumber;
        this.totalEpisodes = builder.totalEpisodes;
        this.blackAndWhite = builder.blackAndWhite;
        this.countriesOfOrigin = Utils.immutableCopyOfOrEmpty(builder.countriesOfOrigin);
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
        this.tags = Utils.immutableCopyOfOrEmpty(builder.tags);
        this.year = builder.year;
    }

    public static Builder<?> builder() {
        return new Builder();
    }

    public static Builder<?> builder(Content content) {
        return Content.builder(content, new Builder());
    }

    public static <B extends Builder<B>> B builder(Content content, B builder) {
        return Described.builder(content, builder)
                .withType(content.type)
                .withDisplayTitle(content.displayTitle)
                .withEpisodeNumber(content.episodeNumber)
                .withSeriesNumber(content.seriesNumber)
                .withTotalEpisodes(content.totalEpisodes)
                .withBlackAndWhite(content.blackAndWhite)
                .withCountriesOfOrigin(content.countriesOfOrigin)
                .withRestrictions(content.restrictions)
                .withCertificates(content.certificates)
                .withLanguages(content.languages)
                .withReleaseDates(content.releaseDates)
                .withContainer(content.container)
                .withSeries(content.series)
                .withContent(content.content)
                .withSubItemSummaries(content.subItemSummaries)
                .withBroadcasts(content.broadcasts)
                .withPeople(content.people)
                .withTags(content.tags)
                .withYear(content.year);
    }

    public Type getType() {
        return type;
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

    public Integer getTotalEpisodes() {
        return totalEpisodes;
    }

    public Boolean getBlackAndWhite() {
        return blackAndWhite;
    }

    public List<String> getCountriesOfOrigin() {
        return countriesOfOrigin;
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

    public List<Tag> getTags() {
        return tags;
    }

    public Integer getYear() {
        return year;
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @SuppressWarnings("unchecked")
    public static final class Builder<B extends Builder<B>> extends Described.Builder<B> {
        private Type type;
        private DisplayTitle displayTitle;
        private Integer episodeNumber;
        private Integer seriesNumber;
        private Integer totalEpisodes;
        private Boolean blackAndWhite;
        private List<String> countriesOfOrigin;
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
        private List<Tag> tags;
        private Integer year;

        public Builder() {
        }

        public B withType(Type type) {
            this.type = type;
            return (B) this;
        }

        public B withDisplayTitle(DisplayTitle displayTitle) {
            this.displayTitle = displayTitle;
            return (B) this;
        }

        public B withEpisodeNumber(Integer episodeNumber) {
            this.episodeNumber = episodeNumber;
            return (B) this;
        }

        public B withSeriesNumber(Integer seriesNumber) {
            this.seriesNumber = seriesNumber;
            return (B) this;
        }

        public B withTotalEpisodes(Integer totalEpisodes) {
            this.totalEpisodes = totalEpisodes;
            return (B) this;
        }

        public B withBlackAndWhite(Boolean blackAndWhite) {
            this.blackAndWhite = blackAndWhite;
            return (B) this;
        }

        public B withCountriesOfOrigin(List<String> countriesOfOrigin) {
            this.countriesOfOrigin = countriesOfOrigin;
            return (B) this;
        }

        public B withRestrictions(List<Restriction> restrictions) {
            this.restrictions = restrictions;
            return (B) this;
        }

        public B withCertificates(List<Certificate> certificates) {
            this.certificates = certificates;
            return (B) this;
        }

        public B withLanguages(List<Language> languages) {
            this.languages = languages;
            return (B) this;
        }

        public B withReleaseDates(List<ReleaseDate> releaseDates) {
            this.releaseDates = releaseDates;
            return (B) this;
        }

        public B withContainer(Container container) {
            this.container = container;
            return (B) this;
        }

        // episode has series singular
        @JsonIgnore
        public B withSeries(Series series) {
            this.series = series == null ? null : ImmutableList.of(series);
            return (B) this;
        }

        // brand has series plural
        @JsonDeserialize(using = SeriesDeserializer.class)
        public B withSeries(List<Series> series) {
            this.series = series;
            return (B) this;
        }

        public B withContent(List<SubItem> content) {
            this.content = content;
            return (B) this;
        }

        public B withSubItemSummaries(List<SubItemSummary> subItemSummaries) {
            this.subItemSummaries = subItemSummaries;
            return (B) this;
        }

        public B withBroadcasts(List<Broadcast> broadcasts) {
            this.broadcasts = broadcasts;
            return (B) this;
        }

        public B withPeople(List<Person> people) {
            this.people = people;
            return (B) this;
        }

        public B withTags(List<Tag> tags) {
            this.tags = tags;
            return (B) this;
        }

        public B withYear(Integer year) {
            this.year = year;
            return (B) this;
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
                    if(jsonParser.nextToken() == JsonToken.END_ARRAY) {
                        return ImmutableList.of();
                    }
                    ImmutableList.Builder<Series> builder = ImmutableList.builder();
                    builder.addAll(jsonParser.readValuesAs(Series.class));
                    return builder.build();
                default:
                    return ImmutableList.of(jsonParser.readValueAs(Series.class));
                }
            }
        }
    }
}
