package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TermsAndConditions {

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
