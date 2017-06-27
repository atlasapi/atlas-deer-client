package org.atlasapi.deer.client.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.atlasapi.deer.client.model.types.Content;
import org.atlasapi.deer.client.model.types.Request;
import org.atlasapi.deer.client.model.types.TermsAndConditions;

@JsonDeserialize(builder = ContentResponse.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentResponse {

    private List<Content> content;

    private TermsAndConditions termsAndConditions;

    private Integer results;

    private Request request;

    private ContentResponse(
            List<Content> content,
            TermsAndConditions termsAndConditions,
            Integer results,
            Request request
    ) {
        this.content = Utils.immutableCopyOfOrEmpty(content);
        this.termsAndConditions = termsAndConditions;
        this.results = results;
        this.request = request;
    }

    @JsonProperty
    public List<Content> getContent() {
        return content;
    }

    @JsonIgnore
    public Content getItem() {
        return Iterables.getFirst(content, null);
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

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<Content> content;
        private TermsAndConditions termsAndConditions;
        private Integer results;
        private Request request;

        public Builder() {
        }

        @JsonProperty
        public Builder content(List<Content> val) {
            content = val;
            return this;
        }

        @JsonProperty
        public Builder item(Content val) {
            content = ImmutableList.of(val);
            return this;
        }

        @JsonProperty("terms_and_conditions")
        public Builder termsAndConditions(TermsAndConditions val) {
            termsAndConditions = val;
            return this;
        }

        @JsonProperty
        public Builder results(Integer val) {
            results = val;
            return this;
        }

        @JsonProperty
        public Builder request(Request val) {
            request = val;
            return this;
        }

        public ContentResponse build() {
            return new ContentResponse(content, termsAndConditions, results, request);
        }
    }
}
