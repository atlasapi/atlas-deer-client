package org.atlasapi.deer.client.model.types;

import java.util.List;

import org.atlasapi.deer.client.model.Utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Channel.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {

    private final String id;
    private final String title;
    private final List<Source> availableFrom;
    private final Source source;
    private final Source broadcaster;
    private final List<Alias> aliases;
    private final String uri;
    private List<SameAs> sameAs;

    private Channel(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.availableFrom = Utils.immutableCopyOfOrEmpty(builder.availableFrom);
        this.source = builder.source;
        this.broadcaster = builder.broadcaster;
        this.aliases = Utils.immutableCopyOfOrEmpty(builder.aliases);
        this.uri = builder.uri;
        this.sameAs = Utils.immutableCopyOfOrEmpty(builder.sameAs);
    }

    public String getId() {
        return id;
    }

    public List<Source> getAvailableFrom() {
        return availableFrom;
    }

    public String getTitle() {
        return title;
    }

    public Source getBroadcaster() {
        return broadcaster;
    }

    public Source getSource() {
        return source;
    }

    public List<Alias> getAliases() {
        return aliases;
    }

    public String getUri() { return uri; }

    public List<SameAs> getSameAs() {
        return sameAs;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String id;
        private String title;
        private List<Source> availableFrom;
        private Source source;
        private Source broadcaster;
        private List<Alias> aliases;
        private String uri;
        private List<SameAs> sameAs;

        public Builder() { }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withAvailableFrom(List<Source> availableFrom) {
            this.availableFrom = availableFrom;
            return this;
        }

        public Builder withSource(Source source) {
            this.source = source;
            return this;
        }

        public Builder withBroadcaster(Source broadcaster) {
            this.broadcaster = broadcaster;
            return this;
        }

        public Builder withAliases(List<Alias> aliases) {
            this.aliases = aliases;
            return this;
        }

        public Builder withUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder withSameAs(List<SameAs> sameAs) {
            this.sameAs = sameAs;
            return this;
        }

        public Channel build() {
            return new Channel(this);
        }
    }
}
