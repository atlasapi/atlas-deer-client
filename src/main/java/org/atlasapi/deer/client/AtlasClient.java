package org.atlasapi.deer.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpTransport;
import com.google.common.net.HostAndPort;
import org.atlasapi.deer.client.http.AtlasHttpClient;
import org.atlasapi.deer.client.model.ContentResponse;
import org.atlasapi.deer.client.model.ScheduleResponse;
import org.atlasapi.deer.client.model.TopicResponse;
import org.atlasapi.deer.client.query.ContentQuery;
import org.atlasapi.deer.client.query.Query;
import org.atlasapi.deer.client.query.ScheduleQuery;
import org.atlasapi.deer.client.query.TopicQuery;
import org.atlasapi.deer.client.uri.AtlasUrlCreator;

import static com.google.common.base.Preconditions.checkNotNull;

public class AtlasClient implements AtlasReadClient, AtlasWriteClient {

    private final AtlasHttpClient httpClient;
    private final AtlasUrlCreator urlCreator;

    /* Package-private for tests */
    AtlasClient(AtlasHttpClient httpClient, AtlasUrlCreator urlCreator) {
        this.httpClient = httpClient;
        this.urlCreator = urlCreator;
    }

    @Override
    public ContentResponse getContent(ContentQuery query) {
        GenericUrl url = getUrl(query, QueryType.Content);
        return httpClient.get(url, ContentResponse.class);
    }

    @Override
    public HttpHeaders headContent(ContentQuery query) {
        GenericUrl url = getUrl(query, QueryType.Content);
        return httpClient.head(url);
    }

    @Override
    public ScheduleResponse getSchedule(ScheduleQuery query) {
        GenericUrl url = getUrl(query, QueryType.Schedule);
        return httpClient.get(url, ScheduleResponse.class);
    }

    @Override
    public TopicResponse getTopic(TopicQuery query) {
        GenericUrl url = getUrl(query, QueryType.Topic);
        return httpClient.get(url, TopicResponse.class);
    }

    private GenericUrl getUrl(Query query, QueryType type) {
        GenericUrl url;

        switch(type){
            case Content:
                if(query.getId().isPresent()) {
                    url = urlCreator.getBuilder()
                            .content(query.getId().get())
                            .addParams(query.getParams())
                            .build();
                }
                else {
                    url = urlCreator.getBuilder()
                            .content()
                            .addParams(query.getParams())
                            .build();
                }
                break;
            case Schedule:
                url = urlCreator.getBuilder()
                        .schedule(query.getId().get())
                        .addParams(query.getParams())
                        .build();
                break;
            case Topic:
                if(query.getId().isPresent()) {
                    url = urlCreator.getBuilder()
                            .topic(query.getId().get())
                            .addParams(query.getParams())
                            .build();
                } else {
                    url = urlCreator.getBuilder()
                            .topic()
                            .addParams(query.getParams())
                            .build();
                }
                break;
            default:
                throw new IllegalArgumentException("Unexpected query type: " + type);
        }

        return url;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private HttpTransport httpTransport;
        private String scheme;
        private HostAndPort host;
        private String apiKey;
        private ObjectMapper objectMapper;

        public Builder() { }

        public Builder withHttpTransport(HttpTransport httpTransport) {
            this.httpTransport = httpTransport;
            return this;
        }

        public Builder withScheme(String scheme) {
            this.scheme = scheme;
            return this;
        }

        public Builder withHost(HostAndPort host) {
            this.host = host;
            return this;
        }

        public Builder withApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder withObjectMapper(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
            return this;
        }

        public AtlasClient build() {
            return new AtlasClient(
                new AtlasHttpClient(checkNotNull(httpTransport), checkNotNull(objectMapper)),
                new AtlasUrlCreator(checkNotNull(scheme), checkNotNull(host), checkNotNull(apiKey))
            );
        }
    }

    private enum QueryType {
        Content,
        Schedule,
        Topic
    }

}
