package org.atlasapi.deer.client.model.types;

import java.util.List;

import org.atlasapi.deer.client.model.Utils;

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

    private Type topicType;
    private String namespace;
    private String value;
    private List<Alias> aliases;

    private Topic(Builder builder) {
        super(builder);
        this.topicType = builder.topicType;
        this.namespace = builder.namespace;
        this.value = builder.value;
        this.aliases = Utils.immutableCopyOfOrEmpty(builder.aliases);
    }

    public static Builder<?> builder() {
        return new Builder();
    }

    public Type getTopicType() {
        return topicType;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getValue() {
        return value;
    }

    public List<Alias> getAliases() {
        return aliases;
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
        private Type topicType;
        private String namespace;
        private String value;
        private List<Alias> aliases;

        public Builder() {

        }

        public B withTopicType(Type val) {
            topicType = val;
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

        public B withAliases(List<Alias> val) {
            aliases = val;
            return (B) this;
        }

        public Topic build() {
            return new Topic(this);
        }

    }

}
