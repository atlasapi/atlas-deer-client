package org.atlasapi.deer.client.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.atlasapi.deer.client.model.types.Request;
import org.atlasapi.deer.client.model.types.TermsAndConditions;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleResponse {

    private TermsAndConditions termsAndConditions;

    private Integer results;

    private Request request;

    @JsonCreator
    public ScheduleResponse(
            @JsonProperty("terms_and_conditions") TermsAndConditions termsAndConditions,
            @JsonProperty("results") Integer results,
            @JsonProperty("request") Request request
    ) {
        this.termsAndConditions = termsAndConditions;
        this.results = results;
        this.request = request;
    }

    @JsonProperty("terms_and_conditions")
    public TermsAndConditions getTermsAndConditions() {
        return termsAndConditions;
    }

    @JsonProperty
    public int getResults() {
        return results;
    }

    @JsonProperty
    public Request getRequest() {
        return request;
    }
}
