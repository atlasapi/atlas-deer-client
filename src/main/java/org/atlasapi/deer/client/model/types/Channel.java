package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.atlasapi.deer.client.model.Utils;

import java.util.List;

@JsonDeserialize(builder = Channel.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {

    private final String id;
    private final String title;
    private final Source source;
    private final List<Alias> aliases;

    private Channel(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.source = builder.source;
        this.aliases = Utils.immutableCopyOfOrEmpty(builder.aliases);
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public Source getSource() {
        return source;
    }

    @JsonProperty
    public List<Alias> getAliases() {
        return aliases;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String id;
        private String title;
        private Source source;
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

        public Builder source(Source source) {
            this.source = source;
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
