package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TermsAndConditions {

    @JsonProperty
    private final String text;

    @JsonCreator
    public TermsAndConditions(
            @JsonProperty("text") String text
    ) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
