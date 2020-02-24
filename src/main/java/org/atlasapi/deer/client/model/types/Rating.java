package org.atlasapi.deer.client.model.types;

import org.atlasapi.media.entity.Publisher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Rating.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rating {

    private final float value;
    private final String type;
    private final Publisher publisher;

    private Rating(Builder builder) {
        value = builder.value;
        type = builder.type;
        publisher = builder.publisher;
    }

    public float getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {

        private float value;
        private String type;
        private Publisher publisher;

        private Builder() {
        }

        public Builder withValue(float value) {
            this.value = value;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withPublisher(Publisher publisher) {
            this.publisher = publisher;
            return this;
        }

        public Rating build() {
            return new Rating(this);
        }
    }
}
