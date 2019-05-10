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

@JsonDeserialize(builder = ChannelGroup.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelGroup {

    private final String id;
    private final String title;
    private final String uri;
    private final String type;
    private final Source source;
    private final List<Alias> aliases;
    private final List<AvailableCountries> availableCountries;
    private final List<ChannelGroup> regions;
    private final List<ChannelWrapper> channels;

    private ChannelGroup(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.uri = builder.uri;
        this.type = builder.type;
        this.source = builder.source;
        this.aliases = builder.aliases;
        this.availableCountries = Utils.immutableCopyOfOrEmpty(builder.availableCountries);
        this.regions = Utils.immutableCopyOfOrEmpty(builder.regions);
        this.channels = Utils.immutableCopyOfOrEmpty(builder.channels);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }

    public String getType() {
        return type;
    }

    public Source getSource() {
        return source;
    }

    public List<Alias> getAliases() {
        return aliases;
    }

    public List<AvailableCountries> getAvailableCountries() {
        return availableCountries;
    }

    public List<ChannelGroup> getRegions() {
        return regions;
    }

    public List<ChannelWrapper> getChannels() {
        return channels;
    }

    @JsonSerialize(using = ToStringSerializer.class)
    public enum Type {
        PLATFORM,
        REGION;

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
    public static final class Builder {

        private String id;
        private String title;
        private String uri;
        private String type;
        private Source source;
        private List<Alias> aliases;
        private List<AvailableCountries> availableCountries;
        private List<ChannelGroup> regions;
        private List<ChannelWrapper> channels;

        public Builder() {
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withSource(Source source) {
            this.source = source;
            return this;
        }

        public Builder withAliases(List<Alias> aliases) {
            this.aliases = aliases;
            return this;
        }

        public Builder withAvailableCountries(List<AvailableCountries> availableCountries) {
            this.availableCountries = availableCountries;
            return this;
        }

        public Builder withRegions(List<ChannelGroup> regions) {
            this.regions = regions;
            return this;
        }

        public Builder withChannels(List<ChannelWrapper> channels) {
            this.channels = channels;
            return this;
        }

        public ChannelGroup build() {
            return new ChannelGroup(this);
        }
    }
}
