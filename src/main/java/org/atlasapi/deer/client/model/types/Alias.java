package org.atlasapi.deer.client.model.types;

import com.google.api.client.util.Key;

import java.util.Objects;

public class Alias {

    @Key
    private String namespace;

    @Key
    private String value;

    public Alias(String namespace, String value) {
        this.namespace = namespace;
        this.value = value;
    }

    public String getNamespace() {
        return namespace;
    }

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
