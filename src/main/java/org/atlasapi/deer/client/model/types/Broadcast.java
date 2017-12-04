package org.atlasapi.deer.client.model.types;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.Ordering;

@JsonDeserialize(builder = Broadcast.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Broadcast {

    private static final Ordering<Broadcast> START_TIME_ORDERING = new BroadcastStartTimeOrdering();

    private final Instant transmissionStartTime;
    private final Instant transmissionEndTime;
    private final Integer broadcastDuration;
    private final String broadcastOn;
    private final Channel channel;
    private final boolean live;
    private final Duration transmissionInterval;

    private Broadcast(Builder builder) {
        this.transmissionStartTime = builder.transmissionStartTime;
        this.transmissionEndTime = builder.transmissionEndTime;
        this.broadcastDuration = builder.broadcastDuration;
        this.broadcastOn = builder.broadcastOn;
        this.channel = builder.channel;
        this.live = builder.live;
        this.transmissionInterval = Duration.between(
                ZonedDateTime.ofInstant(builder.transmissionStartTime, ZoneId.of("UTC")),
                ZonedDateTime.ofInstant(builder.transmissionEndTime, ZoneId.of("UTC")));
    }

    public Instant getTransmissionStartTime() {
        return transmissionStartTime;
    }

    public Instant getTransmissionEndTime() {
        return transmissionEndTime;
    }

    public Integer getBroadcastDuration() {
        return broadcastDuration;
    }

    public String getBroadcastOn() {
        return broadcastOn;
    }

    public Channel getChannel() {
        return channel;
    }

    public boolean getLive() {
        return live;
    }

    public static Ordering<Broadcast> startTimeOrdering() {
        return START_TIME_ORDERING;
    }

    private static final class BroadcastStartTimeOrdering extends Ordering<Broadcast> {

        @Override
        public int compare(Broadcast left, Broadcast right) {
            return left.getTransmissionStartTime().compareTo(right.transmissionStartTime);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private Instant transmissionStartTime;
        private Instant transmissionEndTime;
        private Integer broadcastDuration;
        private String broadcastOn;
        private Channel channel;
        private boolean live;

        public Builder() {}

        @JsonProperty("transmission_time")
        public Builder withTransmissionStartTime(Instant transmissionStartTime) {
            this.transmissionStartTime = transmissionStartTime;
            return this;
        }

        public Builder withTransmissionEndTime(Instant transmissionEndTime) {
            this.transmissionEndTime = transmissionEndTime;
            return this;
        }

        public Builder withBroadcastDuration(Integer broadcastDuration) {
            this.broadcastDuration = broadcastDuration;
            return this;
        }

        public Builder withBroadcastOn(String broadcastOn) {
            this.broadcastOn = broadcastOn;
            return this;
        }

        public Builder withChannel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public Builder withLive(boolean live) {
            this.live = live;
            return this;
        }

        public Broadcast build() {
            return new Broadcast(this);
        }
    }
}
