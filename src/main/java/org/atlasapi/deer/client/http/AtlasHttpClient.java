package org.atlasapi.deer.client.http;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;

public class AtlasHttpClient {

    private final HttpRequestFactory httpRequestFactory;

    public AtlasHttpClient(
            HttpTransport httpTransport,
            ObjectMapper objectMapper
    ) {
        this.httpRequestFactory = httpTransport.createRequestFactory(
                request -> request.setParser(new JacksonParser(objectMapper))
        );
    }

    public <T> T get(GenericUrl url, Class<T> responseContentClazz) {
        try {
            HttpResponse response = httpRequestFactory.buildGetRequest(url).execute();
            return response.parseAs(responseContentClazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute GET request to " + url, e);
        }
    }

    public HttpHeaders head(GenericUrl url) {
        try {
            HttpResponse response = httpRequestFactory.buildHeadRequest(url).execute();
            return response.getHeaders();
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to execute HEAD request to " + url, e);
        }
    }
}
