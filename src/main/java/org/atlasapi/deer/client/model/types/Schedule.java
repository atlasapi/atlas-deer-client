package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Schedule.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Schedule {
    private final Channel channel;
    private final String source;

    private Schedule(Builder builder) {
        this.channel = builder.channel;
        this.source = builder.source;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getSource() {
        return source;
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Channel channel;
        private String source;

        public Builder() { }

        public Builder withChannel(Channel channel) {
            this.channel = channel;
            return this;
        }

        public Builder withSource(String source) {
            this.source = source;
            return this;
        }

        public Schedule build() {
            return new Schedule(this);
        }
    }
}