package org.atlasapi.deer.client.model;

import java.util.List;

import org.atlasapi.deer.client.model.types.Content;
import org.atlasapi.deer.client.model.types.Request;
import org.atlasapi.deer.client.model.types.TermsAndConditions;

import com.google.api.client.util.Key;

public class ContentResponse {

    @Key
    private List<Content> content;

    @Key("terms_and_conditions")
    private TermsAndConditions termsAndConditions;

    @Key
    private Integer results;

    @Key
    private Request request;

    public List<Content> getContent() {
        return content;
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
