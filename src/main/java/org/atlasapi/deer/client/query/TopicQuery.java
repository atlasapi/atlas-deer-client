package org.atlasapi.deer.client.query;

import org.atlasapi.deer.client.uri.Annotation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

public class TopicQuery extends Query {
    public static final String NAMESPACE_PARAM = "aliases.namespace";
    public static final String VALUE_PARAM = "aliases.value";
    public static final String TOPIC_TYPE_PARAM = "topic_type";
    public static final String LIMIT_PARAM = "limit";
    public static final String OFFSET_PARAM = "offset";

    private TopicQuery() {
        super();
    }

    private TopicQuery(String id) {
        super(id);
    }

    private TopicQuery(String... ids) {
        super(ids);
    }

    private TopicQuery(List<String> ids) {
        super(ids);
    }

    public static TopicQuery get() {
        return new TopicQuery();
    }

    public static TopicQuery get(String id) {
        return new TopicQuery(id);
    }

    public static TopicQuery get(String... ids) {
        return new TopicQuery(ids);
    }

    public static TopicQuery get(List<String> ids) {
        return new TopicQuery(ids);
    }

    public TopicQuery addAnnotations(Annotation... annotations) {
        String joinedAnnotations = Arrays.stream(checkNotNull(annotations))
                .distinct()
                .map(Annotation::toKey)
                .collect(Collectors.joining(","));
        params.put(ANNOTATIONS_PARAM, joinedAnnotations);
        return this;
    }

    public TopicQuery addSource(String source) {
        params.put(SOURCE_PARAM, checkNotNull(source));
        return this;
    }

    public TopicQuery addNamespace(String namespace) {
        params.put(NAMESPACE_PARAM, checkNotNull(namespace));
        return this;
    }

    public TopicQuery addValue(String value) {
        params.put(VALUE_PARAM, checkNotNull(value));
        return this;
    }

    public TopicQuery addTopicType(String topicType) {
        params.put(TOPIC_TYPE_PARAM, checkNotNull(topicType));
        return this;
    }

    public TopicQuery addLimit(Integer limit) {
        params.put(LIMIT_PARAM, checkNotNull(limit).toString());
        return this;
    }

    public TopicQuery addOffset(Integer offset) {
        params.put(OFFSET_PARAM, checkNotNull(offset).toString());
        return this;
    }
}
