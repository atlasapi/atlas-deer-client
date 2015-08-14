package org.atlasapi.deer.client.query;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.atlasapi.deer.client.uri.Annotation;

public class ContentQuery extends Query {

    public static final String ALIASES_NAMESPACE_PARAM = "aliases.namespace";
    public static final String ALIASES_VALUE_PARAM = "aliases.value";
    public static final String LIMIT_PARAM = "limit";
    public static final String OFFSET_PARAM = "offset";
    public static final String TYPE_PARAM = "type";

    private ContentQuery() {
        super();
    }
    
    private ContentQuery(String id) {
        super(id);
    }
    
    private ContentQuery(String... ids) {
        super(ids);
    }

    public static ContentQuery get() {
        return new ContentQuery();
    }

    public static ContentQuery get(String id) {
        return new ContentQuery(id);
    }

    public static ContentQuery get(String... ids) {
        return new ContentQuery(ids);
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
