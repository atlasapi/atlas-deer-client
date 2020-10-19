package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = SubItem.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SubItem {

    private final String id;
    private final Content.Type type;

    @JsonCreator
    public SubItem(Builder builder) {
        this.id = builder.id;
        this.type = builder.type;
    }

    public String getId() {
        return id;
    }

    public Content.Type getType() {
        return type;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private String id;
        private Content.Type type;

        public Builder() { }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withType(Content.Type type) {
            this.type = type;
            return this;
        }

        public SubItem build() {
            return new SubItem(this);
        }
    }
}
