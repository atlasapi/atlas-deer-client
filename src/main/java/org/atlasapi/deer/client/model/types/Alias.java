package org.atlasapi.deer.client.model.types;

import com.google.api.client.util.Key;

public class Alias {

    @Key
    private String namespace;

    @Key
    private String value;

    public String getNamespace() {
        return namespace;
    }

    public String getValue() {
        return value;
    }
}
