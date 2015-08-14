package org.atlasapi.deer.client.model;

import org.atlasapi.deer.client.model.types.Request;
import org.atlasapi.deer.client.model.types.TermsAndConditions;

import com.google.api.client.util.Key;

public class ScheduleResponse {

    @Key("terms_and_conditions")
    private TermsAndConditions termsAndConditions;

    @Key
    private Integer results;

    @Key
    private Request request;

    public TermsAndConditions getTermsAndConditions() {
        return termsAndConditions;
    }

    public int getResults() {
        return results;
    }

    public Request getRequest() {
        return request;
    }
}
