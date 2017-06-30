package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.atlasapi.deer.client.model.Utils;

import java.util.List;

@JsonDeserialize(builder = Person.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    private final String role;
    private final String name;
    private final String publisher;
    private final List<String> profileLinks;

    private Person(Builder builder) {
        this.role = builder.role;
        this.name = builder.name;
        this.publisher = builder.publisher;
        this.profileLinks = Utils.immutableCopyOfOrEmpty(builder.profileLinks);
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public List<String> getProfileLinks() {
        return profileLinks;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private String role;
        private String name;
        private String publisher;
        private List<String> profileLinks;

        public Builder() { }

        public Builder withRole(String role) {
            this.role = role;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder withProfileLinks(List<String> profileLinks) {
            this.profileLinks = profileLinks;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

}
