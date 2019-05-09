package org.atlasapi.deer.client.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.atlasapi.deer.client.uri.Annotation;

import static com.google.common.base.Preconditions.checkNotNull;

public class ChannelGroupQuery extends Query {

    private ChannelGroupQuery() {
        super();
    }

    private ChannelGroupQuery(String id) {
        super(id);
    }

    private ChannelGroupQuery(String... ids) {
        super(ids);
    }

    private ChannelGroupQuery(List<String> ids) {
        super(ids);
    }

    public static ChannelGroupQuery get() {
        return new ChannelGroupQuery();
    }

    public static ChannelGroupQuery get(String id) {
        return new ChannelGroupQuery(id);
    }

    public static ChannelGroupQuery get(String... ids) {
        return new ChannelGroupQuery(ids);
    }

    public static ChannelGroupQuery get(List<String> ids) {
        return new ChannelGroupQuery(ids);
    }

    public ChannelGroupQuery addAnnotations(Collection<Annotation> annotations) {
        return addAnnotations(checkNotNull(annotations).stream());
    }

    public ChannelGroupQuery addAnnotations(Annotation... annotations) {
        return addAnnotations(Arrays.stream(checkNotNull(annotations)));
    }

    private ChannelGroupQuery addAnnotations(Stream<Annotation> annotations) {
        params.put(
                ANNOTATIONS_PARAM,
                annotations
                        .distinct()
                        .map(Annotation::toKey)
                        .collect(Collectors.joining(","))
        );
        return this;
    }

    public ChannelGroupQuery addSource(String source) {
        params.put(SOURCE_PARAM, checkNotNull(source));
        return this;
    }
}
