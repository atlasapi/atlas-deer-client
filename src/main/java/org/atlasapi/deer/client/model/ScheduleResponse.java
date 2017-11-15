package org.atlasapi.deer.client.model;

import org.atlasapi.deer.client.model.types.Request;
import org.atlasapi.deer.client.model.types.Schedule;
import org.atlasapi.deer.client.model.types.TermsAndConditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ScheduleResponse.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleResponse {

    private final Schedule schedule;
    private final TermsAndConditions termsAndConditions;
    private final Integer results;
    private final Request request;

    public ScheduleResponse(Builder builder) {
        this.schedule = builder.schedule;
        this.termsAndConditions = builder.termsAndConditions;
        this.results = builder.results;
        this.request = builder.request;
    }

    public Schedule getSchedule() { return schedule; }

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
        private Schedule schedule;
        private TermsAndConditions termsAndConditions;
        private Integer results;
        private Request request;

        public Builder() { }

        public Builder withSchedule(Schedule schedule) {
            this.schedule = schedule;
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

        public ScheduleResponse build() {
            return new ScheduleResponse(this);
        }
    }
}
