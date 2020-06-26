package org.atlasapi.deer.client.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class Query {

    public static final String ID_PARAM = "id";
    public static final String ANNOTATIONS_PARAM = "annotations";
    public static final String SOURCE_PARAM = "source";

    protected final Optional<String> id;
    protected final Map<String, String> params;

    public Query() {
        this.id = Optional.empty();
        this.params = new HashMap<>();
    }

    public Query(Query query) {
        this.id = query.id;
        this.params = new HashMap<>(query.params);
    }

    public Query(String id) {
        this.id = Optional.of(checkNotNull(id));
        this.params = new HashMap<>();
    }

    public Query(String... ids) {
        this.id = Optional.empty();
        this.params = new HashMap<>();
        this.params.put(ID_PARAM, String.join(",", checkNotNull(ids)));
    }

    public Query(List<String> ids) {
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
