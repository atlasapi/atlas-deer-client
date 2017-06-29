package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.atlasapi.deer.client.model.Utils;

import java.util.List;

@JsonDeserialize(builder = Channel.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {

    private final String id;
    private final String title;
    private final List<Broadcaster> availableFrom;
    private final Source source;
    private final Broadcaster broadcaster;
    private final List<Alias> aliases;

    private Channel(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.availableFrom = Utils.immutableCopyOfOrEmpty(builder.availableFrom);
        this.source = builder.source;
        this.broadcaster = builder.broadcaster;
        this.aliases = Utils.immutableCopyOfOrEmpty(builder.aliases);
    }

    public String getId() {
        return id;
    }

    public List<Broadcaster> getAvailableFrom() {
        return availableFrom;
    }

    public String getTitle() {
        return title;
    }

    public Broadcaster getBroadcaster() {
        return broadcaster;
    }

    public Source getSource() {
        return source;
    }

    public List<Alias> getAliases() {
        return aliases;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String id;
        private String title;
        private List<Broadcaster> availableFrom;
        private Source source;
        private Broadcaster broadcaster;
        private List<Alias> aliases;

        public Builder() { }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder availableFrom(List<Broadcaster> availableFrom) {
            this.availableFrom = availableFrom;
            return this;
        }

        public Builder source(Source source) {
            this.source = source;
            return this;
        }

        public Builder broadcaster(Broadcaster broadcaster) {
            this.broadcaster = broadcaster;
            return this;
        }

        public Builder aliases(List<Alias> aliases) {
            this.aliases = aliases;
            return this;
        }

        public Channel build() {
            return new Channel(this);
        }
    }
}
