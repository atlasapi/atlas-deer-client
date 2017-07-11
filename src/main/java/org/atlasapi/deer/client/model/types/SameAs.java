package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Objects;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SameAs {

    private final String id;
    private final String source;

    @JsonCreator
    public SameAs(
            @JsonProperty("id") String id,
            @JsonProperty("source") String source
    ) {
        this.id = id;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public String getSource() {
        return source;
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
                    + "{" + id + "|" + source + "}";
        }
        return str;
    }
}
