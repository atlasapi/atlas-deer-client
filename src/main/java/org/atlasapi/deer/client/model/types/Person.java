package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Person.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    private final String uri;
    private final String curie;
    private final String type;
    private final String name;
    private final String role;

    private Person(Builder builder) {
        this.uri = builder.uri;
        this.curie = builder.curie;
        this.type = builder.type;
        this.role = builder.role;
        this.name = builder.name;
    }

    public String getUri() {
        return uri;
    }

    public String getCurie() {
        return curie;
    }

    public String getType() {
        return type;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private String uri;
        private String curie;
        private String type;
        private String role;
        private String name;

        public Builder() { }

        public Builder withUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder withCurie(String curie) {
            this.curie = curie;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withRole(String role) {
            this.role = role;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

}
