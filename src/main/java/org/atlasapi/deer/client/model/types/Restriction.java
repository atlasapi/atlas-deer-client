package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Restriction {

    private String authority;

    private String rating;

    private String minimumAge;

    private String message;

    @JsonCreator
    public Restriction(
            @JsonProperty("authority") String authority,
            @JsonProperty("rating") String rating,
            @JsonProperty("minimum_age") String minimumAge,
            @JsonProperty("message") String message
    ) {
        this.authority = authority;
        this.rating = rating;
        this.minimumAge = minimumAge;
        this.message = message;
    }

    @JsonProperty
    public String getAuthority() {
        return authority;
    }

    @JsonProperty
    public String getRating() {
        return rating;
    }

    @JsonProperty("minimum_age")
    public String getMinimumAge() {
        return minimumAge;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }
}
