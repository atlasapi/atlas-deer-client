package org.atlasapi.deer.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.atlasapi.deer.client.model.types.Request;
import org.atlasapi.deer.client.model.types.TermsAndConditions;

@JsonDeserialize(builder = ContentResponse.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleResponse {

    private final TermsAndConditions termsAndConditions;
    private final Integer results;
    private final Request request;

    public ScheduleResponse(Builder builder) {
        this.termsAndConditions = builder.termsAndConditions;
        this.results = builder.results;
        this.request = builder.request;
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


    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {
        private TermsAndConditions termsAndConditions;
        private Integer results;
        private Request request;

        public Builder() { }

        public void termsAndConditions(
                TermsAndConditions termsAndConditions) {
            this.termsAndConditions = termsAndConditions;
        }

        public void results(Integer results) {
            this.results = results;
        }

        public void request(Request request) {
            this.request = request;
        }

        public ScheduleResponse build() {
            return new ScheduleResponse(this);
        }
    }
}
