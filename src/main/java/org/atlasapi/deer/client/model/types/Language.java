package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Language.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Language {

    private final String code;
    private final String display;

    private Language(Builder builder) {
        this.code = builder.code;
        this.display = builder.display;
    }

    public String getCode() {
        return code;
    }

    public String getDisplay() {
        return display;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private String code;
        private String display;

        public Builder() { }

        public Builder withDisplay(String display) {
            this.display = display;
            return this;
        }

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Language build() {
            return new Language(this);
        }
    }
}
