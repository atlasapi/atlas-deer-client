package org.atlasapi.deer.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.atlasapi.deer.client.model.types.Request;
import org.atlasapi.deer.client.model.types.Schedule;
import org.atlasapi.deer.client.model.types.TermsAndConditions;
import org.atlasapi.deer.client.model.types.Topic;

import java.util.List;

@JsonDeserialize(builder = TopicResponse.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopicResponse {

    private final List<Topic> topics;
    private final TermsAndConditions termsAndConditions;
    private final Integer results;
    private final Request request;

    public TopicResponse(Builder builder) {
        this.topics = builder.topics;
        this.termsAndConditions = builder.termsAndConditions;
        this.results = builder.results;
        this.request = builder.request;
    }

    public List<Topic> getTopic() { return topics; }

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
        private List<Topic> topics;
        private TermsAndConditions termsAndConditions;
        private Integer results;
        private Request request;

        public Builder() { }

        public Builder withTopics(List<Topic> topics) {
            this.topics = topics;
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

        public TopicResponse build() {
            return new TopicResponse(this);
        }
    }
}
