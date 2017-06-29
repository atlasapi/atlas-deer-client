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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SameAs sameAs = (SameAs) o;
        return Objects.equals(id, sameAs.id) &&
                Objects.equals(source, sameAs.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, source);
    }
}
