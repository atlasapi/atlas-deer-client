package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Rating.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rating {

    private final Float value;
    private final String type;
    private final Source source;
    private final Long numberOfVotes;

    private Rating(Builder builder) {
        value = builder.value;
        type = builder.type;
        source = builder.source;
        numberOfVotes = builder.numberOfVotes;
    }

    public Float getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public Source getSource() {
        return source;
    }

    public Long getNumberOfVotes() {
        return numberOfVotes;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {

        private Float value;
        private String type;
        private Source source;
        private Long numberOfVotes;

        private Builder() {
        }

        public Builder withValue(Float value) {
            this.value = value;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withSource(Source source) {
            this.source = source;
            return this;
        }

        public Builder withNumberOfVotes(Long numberOfVotes) {
            this.numberOfVotes = numberOfVotes;
            return this;
        }

        public Rating build() {
            return new Rating(this);
        }
    }
}
