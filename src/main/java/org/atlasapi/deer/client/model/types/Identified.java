package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.atlasapi.deer.client.model.Utils;

import java.time.Instant;
import java.util.List;

@JsonDeserialize(builder = Identified.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public abstract class Identified {
    private String id;
    private List<Alias> aliases;
    private List<SameAs> sameAs;
    private final Instant lastUpdated;

    protected Identified(Builder builder) {
        this.id = builder.id;
        this.aliases = Utils.immutableCopyOfOrEmpty(builder.aliases);
        this.sameAs = Utils.immutableCopyOfOrEmpty(builder.sameAs);
        this.lastUpdated = builder.lastUpdated;
    }

    protected static Builder<?> builder(Identified identified) {
        return builder(identified, new Builder());
    }

    protected static <B extends Builder<B>> B builder(Identified identified, B builder) {
        return builder
                .withId(identified.id)
                .withAliases(identified.aliases)
                .withSameAs(identified.sameAs)
                .withLastUpdated(identified.lastUpdated)
                ;
    }

    public String getId() {
        return id;
    }

    public List<Alias> getAliases() {
        return aliases;
    }

    public List<SameAs> getSameAs() {
        return sameAs;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @SuppressWarnings("unchecked")
    public static class Builder<B extends Builder<B>> {
        private String id;
        private List<Alias> aliases;
        private List<SameAs> sameAs;
        private Instant lastUpdated;

        public B withId(String val) {
            id = val;
            return (B) this;
        }

        public B withAliases(List<Alias> val) {
            aliases = val;
            return (B) this;
        }

        public B withSameAs(List<SameAs> val) {
            sameAs = val;
            return (B) this;
        }

        public B withLastUpdated(Instant lastUpdated) {
            this.lastUpdated = lastUpdated;
            return (B) this;
        }
    }
}
