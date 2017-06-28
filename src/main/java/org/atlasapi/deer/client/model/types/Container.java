package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Container {

    private final String id;

    @JsonCreator
    public Container(
            @JsonProperty("id") String id
    ) {
        this.id = id;
    }

    @JsonProperty
    public String getId() {
        return id;
    }
}
