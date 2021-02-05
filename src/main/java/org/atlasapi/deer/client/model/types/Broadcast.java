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
    private final Boolean live;
    private final Duration transmissionInterval;
    private final Boolean premiere;
    private final Boolean continuation;
    private final Boolean repeat;
    private final Boolean is3d;
    private final Boolean highDefinition;
    private final Boolean widescreen;
    private final Boolean subtitled;
    private final Boolean signed;
    private final Boolean audioDescribed;

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
        this.premiere = builder.premiere;
        this.continuation = builder.continuation;
        this.repeat = builder.repeat;
        this.is3d = builder.is3d;
        this.highDefinition = builder.highDefinition;
        this.widescreen = builder.widescreen;
        this.subtitled = builder.subtitled;
        this.signed = builder.signed;
        this.audioDescribed = builder.audioDescribed;
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

    public Duration getTransmissionInterval() {
        return transmissionInterval;
    }

    public String getBroadcastOn() {
        return broadcastOn;
    }

    public Channel getChannel() {
        return channel;
    }

    public Boolean getLive() {
        return live;
    }

    public Boolean getPremiere() {
        return premiere;
    }

    public Boolean getContinuation() {
        return continuation;
    }

    public Boolean getRepeat() {
        return repeat;
    }

    public Boolean getIs3d() {
        return is3d;
    }

    public Boolean getHighDefinition() {
        return highDefinition;
    }

    public Boolean getWidescreen() {
        return widescreen;
    }

    public Boolean getSubtitled() {
        return subtitled;
    }

    public Boolean getSigned() {
        return signed;
    }

    public Boolean getAudioDescribed() {
        return audioDescribed;
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
        private Boolean live;
        private Boolean premiere;
        private Boolean continuation;
        private Boolean repeat;
        private Boolean is3d;
        private Boolean highDefinition;
        private Boolean widescreen;
        private Boolean subtitled;
        private Boolean signed;
        private Boolean audioDescribed;

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

        public Builder withLive(Boolean live) {
            this.live = live;
            return this;
        }

        public Builder withPremiere(Boolean premiere) {
            this.premiere = premiere;
            return this;
        }

        public Builder withContinuation(Boolean continuation) {
            this.continuation = continuation;
            return this;
        }

        public Builder withRepeat(Boolean repeat) {
            this.repeat = repeat;
            return this;
        }

        public Builder withIs3d(Boolean is3d) {
            this.is3d = is3d;
            return this;
        }

        public Builder withHighDefinition(Boolean highDefinition) {
            this.highDefinition = highDefinition;
            return this;
        }

        public Builder withWidescreen(Boolean widescreen) {
            this.widescreen = widescreen;
            return this;
        }

        public Builder withSubtitled(Boolean subtitled) {
            this.subtitled = subtitled;
            return this;
        }

        public Builder withSigned(Boolean signed) {
            this.signed = signed;
            return this;
        }

        public Builder withAudioDescribed(Boolean audioDescribed) {
            this.audioDescribed = audioDescribed;
            return this;
        }

        public Broadcast build() {
            return new Broadcast(this);
        }
    }
}
