package org.atlasapi.deer.client.model.types;

import com.google.api.client.util.Key;

public class Series {

    @Key
    private String id;

    public Series(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
