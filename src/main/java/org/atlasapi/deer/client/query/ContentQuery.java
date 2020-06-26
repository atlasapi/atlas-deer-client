package org.atlasapi.deer.client.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.atlasapi.deer.client.uri.Annotation;

import static com.google.common.base.Preconditions.checkNotNull;

public class ContentQuery extends Query {

    public static final String ALIASES_NAMESPACE_PARAM = "aliases.namespace";
    public static final String ALIASES_VALUE_PARAM = "aliases.value";
    public static final String LIMIT_PARAM = "limit";
    public static final String SUB_ITEMS_LIMIT_PARAM = "sub_items.limit";
    public static final String SUB_ITEMS_SUMMARIES_LIMIT_PARAM = "sub_items_summaries.limit";
    public static final String OFFSET_PARAM = "offset";
    public static final String TYPE_PARAM = "type";
    public static final String Q_PARAM = "q";

    private ContentQuery() {
        super();
    }

    private ContentQuery(ContentQuery contentQuery) {
        super(contentQuery);
    }

    public static ContentQuery from(ContentQuery contentQuery) {
        return new ContentQuery(contentQuery);
    }

    private ContentQuery(String id) {
        super(id);
    }
    
    private ContentQuery(String... ids) {
        super(ids);
    }

    private ContentQuery(List<String> ids) {
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

    public static ContentQuery get(List<String> ids) {
        return new ContentQuery(ids);
    }

    public ContentQuery addAnnotations(Collection<Annotation> annotations) {
        return addAnnotations(checkNotNull(annotations).stream());
    }

    public ContentQuery addAnnotations(Annotation... annotations) {
        return addAnnotations(Arrays.stream(checkNotNull(annotations)));
    }

    private ContentQuery addAnnotations(Stream<Annotation> annotations) {
        params.put(
                ANNOTATIONS_PARAM,
                annotations
                        .distinct()
                        .map(Annotation::toKey)
                        .collect(Collectors.joining(","))
        );
        return this;
    }

    public ContentQuery addAlias(String namespace, String value) {
        params.put(ALIASES_NAMESPACE_PARAM, checkNotNull(namespace));
        params.put(ALIASES_VALUE_PARAM, checkNotNull(value));
        return this;
    }

    public ContentQuery addLimit(Integer limit) {
        String sLimit = checkNotNull(limit).toString();
        params.put(LIMIT_PARAM, sLimit);
        params.put(SUB_ITEMS_LIMIT_PARAM, sLimit);
        params.put(SUB_ITEMS_SUMMARIES_LIMIT_PARAM, sLimit);
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

    public ContentQuery addSearchQuery(String searchQuery) {
        params.put(Q_PARAM, checkNotNull(searchQuery));
        return this;
    }
}
