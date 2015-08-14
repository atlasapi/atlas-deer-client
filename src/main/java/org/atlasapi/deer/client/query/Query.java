package org.atlasapi.deer.client.query;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class Query {

    public static final String ID_PARAM = "id";
    public static final String ANNOTATIONS_PARAM = "annotations";
    public static final String SOURCE_PARAM = "source";

    protected final Optional<String> id;
    protected final Map<String, String> params;

    public Query(String id) {
        this.id = Optional.of(checkNotNull(id));
        this.params = new HashMap<>();
    }

    public Query(String... ids) {
        this.id = Optional.empty();
        this.params = new HashMap<>();
        this.params.put(ID_PARAM, String.join(",", checkNotNull(ids)));
    }

    public Optional<String> getId() {
        return id;
    }

    public Map<String, String> getParams() {
        return params;
    }
}