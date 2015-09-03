package org.atlasapi.deer.client;

import static com.google.common.base.Preconditions.checkNotNull;

import org.atlasapi.deer.client.http.AtlasHttpClient;
import org.atlasapi.deer.client.model.ContentResponse;
import org.atlasapi.deer.client.model.ScheduleResponse;
import org.atlasapi.deer.client.query.ContentQuery;
import org.atlasapi.deer.client.query.Query;
import org.atlasapi.deer.client.query.ScheduleQuery;
import org.atlasapi.deer.client.uri.AtlasUrlCreator;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpTransport;
import com.google.common.net.HostSpecifier;

public class AtlasClient implements AtlasReadClient, AtlasWriteClient {

    private final AtlasHttpClient httpClient;
    private final AtlasUrlCreator urlCreator;

    public AtlasClient(HttpTransport httpTransport, String schema, HostSpecifier host,
            String apiKey) {
        this(
                new AtlasHttpClient(checkNotNull(httpTransport)),
                new AtlasUrlCreator(checkNotNull(schema), checkNotNull(host), checkNotNull(apiKey))
        );
    }

    AtlasClient(AtlasHttpClient httpClient, AtlasUrlCreator urlCreator) {
        this.httpClient = httpClient;
        this.urlCreator = urlCreator;
    }

    @Override
    public ContentResponse getContent(ContentQuery query) {
        GenericUrl url = getUrl(query);
        return httpClient.get(url, ContentResponse.class);
    }

    @Override
    public HttpHeaders headContent(ContentQuery query) {
        GenericUrl url = getUrl(query);
        return httpClient.head(url);
    }

    @Override
    public ScheduleResponse getSchedule(ScheduleQuery query) {
        GenericUrl url = getUrl(query);
        return httpClient.get(url, ScheduleResponse.class);
    }

    private GenericUrl getUrl(Query query) {
        GenericUrl url;
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
        return url;
    }

}
