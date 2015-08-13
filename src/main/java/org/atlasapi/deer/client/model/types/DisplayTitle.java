package org.atlasapi.deer.client.model.types;

import com.google.api.client.util.Key;

public class DisplayTitle {

    @Key
    private String title;

    @Key
    private String subtitle;

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
