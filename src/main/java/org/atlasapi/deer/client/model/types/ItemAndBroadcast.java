package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ComparisonChain;

@JsonDeserialize(builder = ItemAndBroadcast.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemAndBroadcast implements Comparable<ItemAndBroadcast> {

    private final Content item;
    private final Broadcast broadcast;

    private ItemAndBroadcast(Builder builder) {
        this.item = builder.item;
        this.broadcast = builder.broadcast;
    }

    public Content getItem() {
        return item;
    }

    public Broadcast getBroadcast() {
        return broadcast;
    }

    @Override
    public int compareTo(ItemAndBroadcast o) {
        return ComparisonChain.start()
                .compare(broadcast, o.broadcast, Broadcast.startTimeOrdering())
                .compare(item.getId(), o.item.getId())
                .result();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Content item;
        private Broadcast broadcast;

        public Builder() { }

        public Builder withItem(Content item) {
            this.item = item;
            return this;
        }

        public Builder withBroadcast(Broadcast broadcast) {
            this.broadcast = broadcast;
            return this;
        }

        public ItemAndBroadcast build() {
            return new ItemAndBroadcast(this);
        }
    }
}