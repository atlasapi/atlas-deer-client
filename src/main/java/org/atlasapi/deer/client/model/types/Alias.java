package org.atlasapi.deer.client.model.types;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Alias {

    private final String namespace;
    private final String value;

    @JsonCreator
    public Alias(
            @JsonProperty("namespace") String namespace,
            @JsonProperty("value") String value
    ) {
        this.namespace = namespace;
        this.value = value;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getValue() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alias alias = (Alias) o;
        return Objects.equals(namespace, alias.namespace) &&
                Objects.equals(value, alias.value);
    }

    private transient int hash = 0;
    @Override public int hashCode() {
        int hash = this.hash;
        if (hash == 0) {
            this.hash = hash = Objects.hash(namespace, value);
        }
        return hash;
    }

    private transient String str = null;
    @Override public String toString() {
        String str = this.str;
        if (str == null) {
            this.str = str = getClass().getSimpleName()
                    + "@" + System.identityHashCode(this)
                    + "{" + namespace + "|" + value + "}";
        }
        return str;
    }
}
