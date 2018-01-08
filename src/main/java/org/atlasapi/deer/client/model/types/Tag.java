package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.metabroadcast.common.collect.ImmutableOptionalMap;
import com.metabroadcast.common.collect.OptionalMap;
import org.atlasapi.media.entity.Publisher;

@JsonDeserialize(builder = Tag.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Tag {

    private long topicId;
    private Publisher publisher;
    private Boolean supervised;
    private Float weighting;
    private Relationship relationship;
    private Integer offset;

    private Tag(Builder builder) {
        this.topicId = builder.topicId;
        this.publisher = builder.publisher;
        this.supervised = builder.supervised;
        this.weighting = builder.weighting;
        this.relationship = builder.relationship;
        this.offset = builder.offset;
    }

    public long getTopicId() {
        return topicId;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Boolean isSupervised() {
        return supervised;
    }

    public Float getWeighting() {
        return weighting;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public Integer getOffset() {
        return this.offset;
    }

    @JsonSerialize(using = ToStringSerializer.class)
    public enum Relationship {

        ABOUT("about"),
        TWITTER_AUDIENCE("twitter:audience"),
        TWITTER_AUDIENCE_RELATED("twitter:audience-related"),
        TWITTER_AUDIENCE_REALTIME("twitter:audience:realtime"),
        TRANSCRIPTION("transcription"),
        TRANSCRIPTION_SUBTITLES("transcription:subtitles"),
        TRANSCRIPTION_SUBTITLES_REALTIME("transcription:subtitles:realtime");

        private static ImmutableSet<Relationship> ALL = ImmutableSet.copyOf(values());

        public static ImmutableSet<Relationship> all() {
            return ALL;
        }

        private static final OptionalMap<String, Relationship> INDEX =
                ImmutableOptionalMap.fromMap(Maps.uniqueIndex(all(), Relationship::key));

        private final String key;

        Relationship(String key) {
            this.key = key;
        }

        public String key() {
            return key;
        }

        @Override
        public String toString() {
            return key;
        }

        @JsonCreator
        public static Relationship fromKey(String key) {
            return INDEX.get(key).orNull();
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private long topicId;
        private Publisher publisher;
        private Boolean supervised;
        private Float weighting;
        private Relationship relationship;
        private Integer offset;

        public Builder() {

        }

        public Builder withTopicId(long val) {
            topicId = val;
            return this;
        }

        @JsonProperty
        public Builder withPublisher(String val) {
            return withPublisher(Publisher.fromKey(val).valueOrNull());
        }

        @JsonIgnore
        public Builder withPublisher(Publisher val) {
            publisher = val;
            return this;
        }

        public Builder withSupervised(Boolean val) {
            supervised = val;
            return this;
        }

        public Builder withWeighting(Float val) {
            weighting = val;
            return this;
        }

        public Builder withRelationship(Relationship val) {
            relationship = val;
            return this;
        }

        public Builder withOffset(Integer val){
            offset = val;
            return this;
        }

        public Tag build() {
            return new Tag(this);
        }


    }
}
