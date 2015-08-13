package org.atlasapi.deer.client.model;

import org.atlasapi.deer.client.model.types.Episode;
import org.atlasapi.deer.client.model.types.Request;
import org.atlasapi.deer.client.model.types.TermsAndConditions;

import com.google.api.client.util.Key;

public class ContentResponse {

    @Key
    private Episode episode;

    @Key("terms_and_conditions")
    private TermsAndConditions termsAndConditions;

    @Key
    private Integer results;

    @Key
    private Request request;

    public Episode getEpisode() {
        return episode;
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
}
