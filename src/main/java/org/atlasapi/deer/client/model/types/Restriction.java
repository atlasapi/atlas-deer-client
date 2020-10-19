package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Restriction.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restriction {

    private final String authority;
    private final String rating;
    private final Integer minimumAge;
    private final String message;

    private Restriction(Builder builder) {
        this.authority = builder.authority;
        this.rating = builder.rating;
        this.minimumAge = builder.minimumAge;
        this.message = builder.message;
    }

    public String getAuthority() {
        return authority;
    }

    public String getRating() {
        return rating;
    }

    public Integer getMinimumAge() {
        return minimumAge;
    }

    public String getMessage() {
        return message;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private String authority;
        private String rating;
        @JsonProperty("minimumAge") private Integer minimumAge;
        private String message;

        public Builder() { }

        public Builder withAuthority(String authority) {
            this.authority = authority;
            return this;
        }

        public Builder withRating(String rating) {
            this.rating = rating;
            return this;
        }

        public Builder withMinimumAge(Integer minimumAge) {
            this.minimumAge = minimumAge;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Restriction build() {
            return new Restriction(this);
        }
    }
}
