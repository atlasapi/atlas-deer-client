package org.atlasapi.deer.client.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                 + ((id == null) ? 0 : id.hashCode())
                 + ((params == null) ? 0 : params.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }
        final Query other = (Query) obj;
        return this.getId().equals(other.getId())
               && this.getParams().equals(other.getParams());
    }
}
