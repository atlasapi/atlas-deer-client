package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Source {

    private final String key;

    private final String name;

    private final String country;

    @JsonCreator
    public Source(
            @JsonProperty("key") String key,
            @JsonProperty("name") String name,
            @JsonProperty("country") String country
    ) {
        this.key = key;
        this.name = name;
        this.country = country;
    }

    @JsonProperty
    public String getKey() {
        return key;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getCountry() {
        return country;
    }
}
