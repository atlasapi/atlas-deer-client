package org.atlasapi.deer.client.model.types;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = SameAs.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SameAs {

    private final String id;
    private final String source;
    private String uri;

    @JsonCreator
    public SameAs(Builder builder) {
        this.id = builder.id;
        this.source = builder.source;
        this.uri = builder.uri;
    }

    @JsonIgnore
    public SameAs(String id, String source) {
        this.id = id;
        this.source = source;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getUri() {
        return uri;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SameAs that = (SameAs) o;
        return Objects.equals(this.id, that.id);
    }

    @Override public int hashCode() {
        return Objects.hashCode(id);
    }

    private transient String str = null;
    @Override public String toString() {
        String str = this.str;
        if (str == null) {
            this.str = str = getClass().getSimpleName()
                    + "@" + System.identityHashCode(this)
                    + "{" + id + "|" + source + "|" + uri + "}";
        }
        return str;
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private String id;
        private String source;
        private String uri;

        public Builder() { }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withSource(String source) {
            this.source = source;
            return this;
        }

        public Builder withUri(String uri) {
            this.uri = uri;
            return this;
        }

        public SameAs build() {
            return new SameAs(this);
        }
    }
}
