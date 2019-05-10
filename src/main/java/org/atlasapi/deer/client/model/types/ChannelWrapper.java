package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ChannelWrapper.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelWrapper {

    private final Channel channel;
    private final String channelNumber;
    private final String startDate;
    private final String endDate;

    private ChannelWrapper(Builder builder) {
        this.channel = builder.channel;
        this.channelNumber = builder.channelNumber;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Channel getChannel() {
        return channel;
    }

    public String getChannelNumber() {
        return channelNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {

        private Channel channel;
        private String channelNumber;
        private String startDate;
        private String endDate;

        public Builder() {

        }

        public Builder withChannel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public Builder withChannelNumber(String channelNumber) {
            this.channelNumber = channelNumber;
            return this;
        }

        public Builder withStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public ChannelWrapper build() {
            return new ChannelWrapper(this);
        }

    }
}
