package org.atlasapi.deer.client.model;

import java.util.List;

import org.atlasapi.deer.client.model.types.ChannelGroup;
import org.atlasapi.deer.client.model.types.Request;
import org.atlasapi.deer.client.model.types.TermsAndConditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ChannelGroupResponse.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelGroupResponse {

    private final List<ChannelGroup> channelGroups;
    private final TermsAndConditions termsAndConditions;
    private final Integer results;
    private final Request request;

    public ChannelGroupResponse(Builder builder) {
        this.channelGroups = builder.channelGroups;
        this.termsAndConditions = builder.termsAndConditions;
        this.results = builder.results;
        this.request = builder.request;
    }

    public List<ChannelGroup> getChannelGroups() { return channelGroups; }

    public TermsAndConditions getTermsAndConditions() {
        return termsAndConditions;
    }

    public int getResults() {
        return results;
    }

    public Request getRequest() {
        return request;
    }


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private List<ChannelGroup> channelGroups;
        private TermsAndConditions termsAndConditions;
        private Integer results;
        private Request request;

        public Builder() { }

        public Builder withChannelGroups(List<ChannelGroup> channelGroups) {
            this.channelGroups = channelGroups;
            return this;
        }

        public Builder withTermsAndConditions(TermsAndConditions termsAndConditions) {
            this.termsAndConditions = termsAndConditions;
            return this;
        }

        public Builder withResults(Integer results) {
            this.results = results;
            return this;
        }

        public Builder withRequest(Request request) {
            this.request = request;
            return this;
        }

        public ChannelGroupResponse build() {
            return new ChannelGroupResponse(this);
        }
    }
}
