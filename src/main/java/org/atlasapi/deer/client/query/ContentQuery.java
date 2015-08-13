package org.atlasapi.deer.client.query;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.atlasapi.deer.client.uri.Annotation;

public class ContentQuery {

    public static final String ID_PARAM = "id";
    public static final String ANNOTATIONS_PARAM = "annotations";
    public static final String ALIASES_NAMESPACE_PARAM = "aliases.namespace";
    public static final String ALIASES_VALUE_PARAM = "aliases.value";
    public static final String LIMIT_PARAM = "limit";
    public static final String OFFSET_PARAM = "offset";
    public static final String SOURCE_PARAM = "source";
    public static final String TYPE_PARAM = "type";
    
    private final Optional<String> id;
    private final Map<String, String> params;
    
    private ContentQuery(String id) {
        this.id = Optional.of(checkNotNull(id));
        this.params = new HashMap<>();
    }
    
    private ContentQuery(String... ids) {
        this.id = Optional.empty();
        this.params = new HashMap<>();
        this.params.put(ID_PARAM, String.join(",", checkNotNull(ids)));
    }

    public static ContentQuery get(String id) {
        return new ContentQuery(id);
    }

    public static ContentQuery get(String... ids) {
        return new ContentQuery(ids);
    }

    public Optional<String> getId() {
        return id;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public ContentQuery addAnnotations(Annotation... annotations) {
        String joinedAnnotations = Arrays.stream(checkNotNull(annotations))
                .distinct()
                .map(Annotation::toKey)
                .collect(Collectors.joining(","));
        params.put(ANNOTATIONS_PARAM, joinedAnnotations);
        return this;
    }

    public ContentQuery addAlias(String namespace, String value) {
        params.put(ALIASES_NAMESPACE_PARAM, checkNotNull(namespace));
        params.put(ALIASES_VALUE_PARAM, checkNotNull(value));
        return this;
    }

    public ContentQuery addLimit(Integer limit) {
        params.put(LIMIT_PARAM, checkNotNull(limit).toString());
        return this;
    }

    public ContentQuery addOffset(Integer offset) {
        params.put(OFFSET_PARAM, checkNotNull(offset).toString());
        return this;
    }

    public ContentQuery addSource(String source) {
        params.put(SOURCE_PARAM, checkNotNull(source));
        return this;
    }

    public ContentQuery addType(String type) {
        params.put(TYPE_PARAM, checkNotNull(type));
        return this;
    }
}
