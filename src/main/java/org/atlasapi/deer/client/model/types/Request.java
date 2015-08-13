package org.atlasapi.deer.client.model.types;

import java.util.Map;

import com.google.api.client.util.Key;

public class Request {

    @Key
    private String path;

    @Key
    private Map<String, String> parameters;

    public String getPath() {
        return path;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }
}
