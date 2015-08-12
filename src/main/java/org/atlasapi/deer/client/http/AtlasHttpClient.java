package org.atlasapi.deer.client.http;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;

public class AtlasHttpClient {

    private final HttpRequestFactory httpRequestFactory;
    private final ObjectMapper objectMapper;

    public AtlasHttpClient() {
        this(new NetHttpTransport().createRequestFactory());
    }

    AtlasHttpClient(HttpRequestFactory httpRequestFactory) {
        this.httpRequestFactory = httpRequestFactory;
        this.objectMapper = new ObjectMapper();
    }

    public <T> T get(GenericUrl url, Class<T> responseContentClazz) {
        try {
            HttpResponse response = httpRequestFactory.buildGetRequest(url).execute();
            return objectMapper.readValue(response.getContent(), responseContentClazz);
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to execute GET request to " + url, e);
        }
    }
}
