package org.atlasapi.deer.client.model.types;

import com.google.api.client.util.Key;

public class DisplayTitle {

    @Key
    private String title;

    @Key
    private String subtitle;

    public DisplayTitle(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
