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

    private ContentResponse(
            List<Content> content,
            TermsAndConditions termsAndConditions,
            Integer results,
            Request request
    ) {
        this.content = content;
        this.termsAndConditions = termsAndConditions;
        this.results = results;
        this.request = request;
    }

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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<Content> content;
        private TermsAndConditions termsAndConditions;
        private Integer results;
        private Request request;

        public Builder() {
        }

        public Builder content(List<Content> val) {
            content = val;
            return this;
        }

        public Builder termsAndConditions(TermsAndConditions val) {
            termsAndConditions = val;
            return this;
        }

        public Builder results(Integer val) {
            results = val;
            return this;
        }

        public Builder request(Request val) {
            request = val;
            return this;
        }

        public ContentResponse build() {
            return new ContentResponse(content, termsAndConditions, results, request);
        }
    }
}
