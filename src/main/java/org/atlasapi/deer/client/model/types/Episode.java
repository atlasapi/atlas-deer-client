package org.atlasapi.deer.client.model.types;

import java.util.List;

import com.google.api.client.util.Key;

public class Episode {

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
}
