package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.api.client.util.Key;

import java.util.Objects;

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

    @JsonProperty
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alias alias = (Alias) o;
        return Objects.equals(namespace, alias.namespace) &&
                Objects.equals(value, alias.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namespace, value);
    }
}
