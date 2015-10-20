package org.atlasapi.deer.client.model.types;

import com.google.api.client.util.Key;

public class TermsAndConditions {

    @Key
    private String text;

    public TermsAndConditions(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
