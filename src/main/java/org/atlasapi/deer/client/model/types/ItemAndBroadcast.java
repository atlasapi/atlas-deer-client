package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.base.Function;
import com.google.common.collect.ComparisonChain;

@JsonDeserialize(builder = ItemAndBroadcast.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemAndBroadcast implements Comparable<ItemAndBroadcast> {

    private static final Function<ItemAndBroadcast, Broadcast> TO_BROADCAST =
            new Function<ItemAndBroadcast, Broadcast>() {
                @Override
                public Broadcast apply(ItemAndBroadcast input) {
                    return input.getBroadcast();
                }

            };

    public static final Function<ItemAndBroadcast, Broadcast> toBroadcast() {
        return TO_BROADCAST;
    }

    private static final Function<ItemAndBroadcast, Item> TO_ITEM =
            new Function<ItemAndBroadcast, Item>() {
                @Override
                public Item apply(ItemAndBroadcast input) {
                    return input.getItem();
                }
            };

    public static final Function<ItemAndBroadcast, Item> toItem() {
        return TO_ITEM;
    }

    private final Item item;
    private final Broadcast broadcast;

    private ItemAndBroadcast(Builder builder) {
        this.item = builder.item;
        this.broadcast = builder.broadcast;
    }

    @JsonProperty("item")
    public Item getItem() {
        return item;
    }

    @JsonProperty("broadcast")
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
        private Item item;
        private Broadcast broadcast;

        public Builder() { }

        public Builder withItem(Item item) {
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