package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisplayTitle {

    private final String title;

    private final String subtitle;

    @JsonCreator
    public DisplayTitle(
            @JsonProperty("title") String title,
            @JsonProperty("subtitle") String subtitle
    ) {
        this.title = title;
        this.subtitle = subtitle;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getSubtitle() {
        return subtitle;
    }
}
