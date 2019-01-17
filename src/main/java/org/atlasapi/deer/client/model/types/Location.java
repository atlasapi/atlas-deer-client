package org.atlasapi.deer.client.model.types;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Location.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private final String uri;
    private final Instant availabilityStart;
    private final Instant availabilityEnd;
    private final Integer duration;

    private Location(Builder builder) {
        this.uri = builder.uri;
        this.availabilityStart = builder.availabilityStart;
        this.availabilityEnd = builder.availabilityEnd;
        this.duration = builder.duration;
    }

    public String getUri() {
        return uri;
    }

    public Instant getAvailabilityStart() {
        return availabilityStart;
    }

    public Instant getAvailabilityEnd() {
        return availabilityEnd;
    }

    public Integer getDuration() {
        return duration;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private String uri;
        private Instant availabilityStart;
        private Instant availabilityEnd;
        private Integer duration;

        public Builder() {}

        public Builder withUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder withAvailabilityStart(Instant availabilityStart) {
            this.availabilityStart = availabilityStart;
            return this;
        }

        public Builder withAvailabilityEnd(Instant availabilityEnd) {
            this.availabilityEnd = availabilityEnd;
            return this;
        }

        public Builder withDuration(Integer duration) {
            this.duration = duration;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}
