package org.atlasapi.deer.client.model.types;

import com.google.api.client.util.Key;

public class Restriction {

    @Key
    private String authority;

    @Key
    private String rating;

    @Key
    private String minimumAge;

    @Key
    private String message;

    public Restriction(String authority, String rating, String minimumAge, String message) {
        this.authority = authority;
        this.rating = rating;
        this.minimumAge = minimumAge;
        this.message = message;
    }

    public String getAuthority() {
        return authority;
    }

    public String getRating() {
        return rating;
    }

    public String getMinimumAge() {
        return minimumAge;
    }

    public String getMessage() {
        return message;
    }
}
