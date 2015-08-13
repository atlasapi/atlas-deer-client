package org.atlasapi.deer.client;

import static com.google.common.base.Preconditions.checkNotNull;

import org.atlasapi.deer.client.http.AtlasHttpClient;
import org.atlasapi.deer.client.model.ContentResponse;
import org.atlasapi.deer.client.query.ContentQuery;
import org.atlasapi.deer.client.uri.AtlasUrlCreator;

import com.google.api.client.http.GenericUrl;
import com.google.common.net.HostSpecifier;

public class AtlasClient implements AtlasReadClient, AtlasWriteClient {

    private final AtlasHttpClient httpClient;
    private final AtlasUrlCreator urlCreator;

    public AtlasClient(String schema, HostSpecifier host, String apiKey) {
        this(
                new AtlasHttpClient(),
                new AtlasUrlCreator(checkNotNull(schema), checkNotNull(host), checkNotNull(apiKey))
        );
    }

    AtlasClient(AtlasHttpClient httpClient, AtlasUrlCreator urlCreator) {
        this.httpClient = httpClient;
        this.urlCreator = urlCreator;
    }

    public ContentResponse getContent(ContentQuery query) {
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

        return httpClient.get(url, ContentResponse.class);
    }
}
