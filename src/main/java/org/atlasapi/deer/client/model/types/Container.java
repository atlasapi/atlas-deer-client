package org.atlasapi.deer.client.model.types;

import com.google.api.client.util.Key;

public class Container {

    @Key
    private String id;

    public Container(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
