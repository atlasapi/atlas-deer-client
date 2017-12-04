package org.atlasapi.deer.client.model.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

@JsonDeserialize(builder = Schedule.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Schedule {

    public static Function<Schedule, ImmutableList<ItemAndBroadcast>> toEntries() {
        return TO_ENTRIES;
    }

    private static final Function<Schedule, ImmutableList<ItemAndBroadcast>> TO_ENTRIES
            = input -> input.entries;

    private final Channel channel;
    private final String source;
    private final ImmutableList<ItemAndBroadcast> entries;

    private Schedule(Builder builder) {
        this.channel = builder.channel;
        this.source = builder.source;
        this.entries = builder.entries;
    }

    public Channel getChannel() {
        return channel;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("entries")
    public List<ItemAndBroadcast> getEntries() {
        return entries;
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Channel channel;
        private String source;
        private ImmutableList<ItemAndBroadcast> entries;

        public Builder() { }

        public Builder withChannel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public Builder withSource(String source) {
            this.source = source;
            return this;
        }

        public Builder withEntries(Iterable<ItemAndBroadcast> entries) {
            this.entries = Ordering.natural().immutableSortedCopy(entries);
            return this;
        }

        public Schedule build() {
            return new Schedule(this);
        }
    }
}