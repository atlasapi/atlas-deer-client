package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Broadcast.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Broadcast {

    private final String transmissionStartTime;
    private final String transmissionEndTime;
    private final Integer broadcastDuration;
    private final String broadcastOn;
    private final Channel channel;

    private Broadcast(Builder builder) {
        this.transmissionStartTime = builder.transmissionStartTime;
        this.transmissionEndTime = builder.transmissionEndTime;
        this.broadcastDuration = builder.broadcastDuration;
        this.broadcastOn = builder.broadcastOn;
        this.channel = builder.channel;
    }

    @JsonProperty("transmission_time")
    public String getTransmissionStartTime() {
        return transmissionStartTime;
    }

    public String getTransmissionEndTime() {
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


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private String transmissionStartTime;
        private String transmissionEndTime;
        private Integer broadcastDuration;
        private String broadcastOn;
        private Channel channel;

        public Builder() {}

        @JsonProperty("transmission_time")
        public Builder transmissionStartTime(String transmissionStartTime) {
            this.transmissionStartTime = transmissionStartTime;
            return this;
        }

        public Builder transmissionEndTime(String transmissionEndTime) {
            this.transmissionEndTime = transmissionEndTime;
            return this;
        }

        public Builder broadcastDuration(Integer broadcastDuration) {
            this.broadcastDuration = broadcastDuration;
            return this;
        }

        public Builder broadcastOn(String broadcastOn) {
            this.broadcastOn = broadcastOn;
            return this;
        }

        public Builder channel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public Broadcast build() {
            return new Broadcast(this);
        }
    }
}
