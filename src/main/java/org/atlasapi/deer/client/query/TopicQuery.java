package org.atlasapi.deer.client.query;

import org.atlasapi.deer.client.uri.Annotation;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

public class TopicQuery extends Query {
    public static final String NAMESPACE_PARAM = "aliases.namespace";
    public static final String VALUE_PARAM = "aliases.value";
    public static final String TOPIC_TYPE_PARAM = "topic_type";

    public TopicQuery() {
        super();
    }


    public static TopicQuery get() {
        return new TopicQuery();
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
}
