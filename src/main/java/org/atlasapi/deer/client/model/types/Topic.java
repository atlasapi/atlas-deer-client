package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@JsonDeserialize(builder = Topic.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Topic extends Described {

    private Type type;
    private String namespace;
    private String value;

    private Topic(Builder builder) {
        super(builder);
        this.type = builder.type;
        this.namespace = builder.namespace;
        this.value = builder.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Type getType() {
        return type;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getValue() {
        return value;
    }

    @JsonSerialize(using = ToStringSerializer.class)
    public enum Type {
        SUBJECT,
        PERSON,
        PLACE,
        ARTIST,
        EVENT,
        PRODUCT,
        WORK,
        GENRE,
        UNKNOWN;

        private final String str = name().toLowerCase();

        @Override
        public String toString() {
            return str;
        }

        @JsonCreator
        public static Type fromString(String str) {
            return valueOf(str.toUpperCase());
        }

    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @SuppressWarnings("unchecked")
    public static final class Builder<B extends Builder<B>> extends Described.Builder<B> {
        private Type type;
        private String namespace;
        private String value;

        public Builder() {

        }

        public B withType(Type val) {
            type = val;
            return (B) this;
        }

        public B withNamespace(String val) {
            namespace = val;
            return (B) this;
        }

        public B withValue(String val) {
            value = val;
            return (B) this;
        }

        public Topic build() {
            return new Topic(this);
        }

    }

}
