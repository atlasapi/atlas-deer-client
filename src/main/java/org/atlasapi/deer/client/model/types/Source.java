package org.atlasapi.deer.client.model.types;

import com.google.api.client.util.Key;

public class Source {

    @Key
    private String key;

    @Key
    private String name;

    @Key
    private String country;

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
