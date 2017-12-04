package org.atlasapi.deer.client.model.types;

import java.util.Date;

import com.metabroadcast.common.time.IntervalOrdering;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.Ordering;
import org.joda.time.DateTime;
import org.joda.time.Interval;

@JsonDeserialize(builder = Broadcast.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Broadcast {

    private static final Ordering<Broadcast> START_TIME_ORDERING = new BroadcastStartTimeOrdering();

    private final Date transmissionStartTime;
    private final Date transmissionEndTime;
    private final Integer broadcastDuration;
    private final String broadcastOn;
    private final Channel channel;
    private final boolean live;
    private final Interval transmissionInterval;

    private Broadcast(Builder builder) {
        this.transmissionStartTime = builder.transmissionStartTime;
        this.transmissionEndTime = builder.transmissionEndTime;
        this.broadcastDuration = builder.broadcastDuration;
        this.broadcastOn = builder.broadcastOn;
        this.channel = builder.channel;
        this.live = builder.live;
        this.transmissionInterval = new Interval(
                new DateTime(builder.transmissionStartTime),
                new DateTime(builder.transmissionEndTime));
    }

    @JsonProperty("transmission_time")
    public Date getTransmissionStartTime() {
        return transmissionStartTime;
    }

    @JsonProperty("transmission_end_time")
    public Date getTransmissionEndTime() {
        return transmissionEndTime;
    }

    @JsonProperty("broadcast_duration")
    public Integer getBroadcastDuration() {
        return broadcastDuration;
    }

    @JsonProperty("broadcast_on")
    public String getBroadcastOn() {
        return broadcastOn;
    }

    @JsonProperty("channel")
    public Channel getChannel() {
        return channel;
    }

    @JsonProperty("live")
    public boolean getLive() {
        return live;
    }

    public static Ordering<Broadcast> startTimeOrdering() {
        return START_TIME_ORDERING;
    }

    private static final class BroadcastStartTimeOrdering extends Ordering<Broadcast> {

        @Override
        public int compare(Broadcast left, Broadcast right) {
            return IntervalOrdering.byStartShortestFirst()
                    .compare(left.transmissionInterval, right.transmissionInterval);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private Date transmissionStartTime;
        private Date transmissionEndTime;
        private Integer broadcastDuration;
        private String broadcastOn;
        private Channel channel;
        private boolean live;

        public Builder() {}

        @JsonProperty("transmission_time")
        public Builder withTransmissionStartTime(Date transmissionStartTime) {
            this.transmissionStartTime = transmissionStartTime;
            return this;
        }

        public Builder withTransmissionEndTime(Date transmissionEndTime) {
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
