package org.atlasapi.deer.client.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.Iterables;
import org.atlasapi.deer.client.model.types.Channel;
import org.atlasapi.deer.client.model.types.Request;
import org.atlasapi.deer.client.model.types.TermsAndConditions;

import java.util.List;

@JsonDeserialize(builder = ChannelResponse.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelResponse {
    
    private List<Channel> channels;
    private TermsAndConditions termsAndConditions;
    private Integer results;
    private Request request;

    private ChannelResponse(ChannelResponse.Builder builder) {
        this.channels = Utils.immutableCopyOfOrEmpty(builder.channels);
        this.termsAndConditions = builder.termsAndConditions;
        this.results = builder.results;
        this.request = builder.request;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    @JsonIgnore
    public Channel getChannel() {
        return Iterables.getFirst(channels, null);
    }

    public TermsAndConditions getTermsAndConditions() {
        return termsAndConditions;
    }

    public int getResults() {
        return results;
    }

    public Request getRequest() {
        return request;
    }


    public static ChannelResponse.Builder builder() {
        return new ChannelResponse.Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<Channel> channels;
        private TermsAndConditions termsAndConditions;
        private Integer results;
        private Request request;

        public Builder() { }

        public ChannelResponse.Builder withChannels(List<Channel> val) {
            channels = val;
            return this;
        }

        public ChannelResponse.Builder withTermsAndConditions(TermsAndConditions val) {
            termsAndConditions = val;
            return this;
        }

        public ChannelResponse.Builder withResults(Integer val) {
            results = val;
            return this;
        }

        public ChannelResponse.Builder withRequest(Request val) {
            request = val;
            return this;
        }

        public ChannelResponse build() {
            return new ChannelResponse(this);
        }
    }
}
