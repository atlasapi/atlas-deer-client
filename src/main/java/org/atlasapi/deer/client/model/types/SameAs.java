package org.atlasapi.deer.client.model.types;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SameAs {

    private final String id;
    private final String source;
    private final String uri;
    
    @JsonCreator
    public SameAs(
            @JsonProperty("id") String id,
            @JsonProperty("source") String source,
            @JsonProperty("uri") String uri
    ) {
        this.id = id;
        this.source = source;
        this.uri = uri;
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
}
