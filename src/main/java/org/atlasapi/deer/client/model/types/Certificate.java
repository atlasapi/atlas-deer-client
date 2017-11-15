package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Certificate.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Certificate {

    private final String classification;
    private final String code;

    private Certificate(Builder builder) {
        this.classification = builder.classification;
        this.code = builder.code;
    }

    public String getClassification() {
        return classification;
    }

    public String getCode() {
        return code;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private String classification;
        private String code;

        public Builder() { }

        public Builder withClassification(String classification) {
            this.classification = classification;
            return this;
        }

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Certificate build() {
            return new Certificate(this);
        }
    }
}
