package org.atlasapi.deer.client.model;

import java.util.List;

import org.atlasapi.deer.client.model.types.Content;
import org.atlasapi.deer.client.model.types.Request;
import org.atlasapi.deer.client.model.types.TermsAndConditions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.Iterables;

@JsonDeserialize(builder = ContentResponse.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentResponse {

    private List<Content> content;
    private TermsAndConditions termsAndConditions;
    private Integer results;
    private Request request;

    private ContentResponse(Builder builder) {
        this.content = Utils.immutableCopyOfOrEmpty(builder.content);
        this.termsAndConditions = builder.termsAndConditions;
        this.results = builder.results;
        this.request = builder.request;
    }

    public List<Content> getContent() {
        return content;
    }

    @JsonIgnore
    public Content getItem() {
        return Iterables.getFirst(content, null);
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

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<Content> content;
        private TermsAndConditions termsAndConditions;
        private Integer results;
        private Request request;

        public Builder() { }

        public Builder withContent(List<Content> val) {
            content = val;
            return this;
        }

        public Builder withTermsAndConditions(TermsAndConditions val) {
            termsAndConditions = val;
            return this;
        }

        public Builder withResults(Integer val) {
            results = val;
            return this;
        }

        public Builder withRequest(Request val) {
            request = val;
            return this;
        }

        public ContentResponse build() {
            return new ContentResponse(this);
        }
    }
}
