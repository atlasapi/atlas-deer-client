package org.atlasapi.deer.client.query;

import org.atlasapi.deer.client.uri.Annotation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkNotNull;

public class ChannelGroupQuery extends Query {

    public static final String LIMIT_PARAM = "limit";
    public static final String OFFSET_PARAM = "offset";

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

    public ChannelGroupQuery addLimit(Integer limit) {
        params.put(LIMIT_PARAM, checkNotNull(limit).toString());
        return this;
    }

    public ChannelGroupQuery addOffset(Integer offset) {
        params.put(OFFSET_PARAM, checkNotNull(offset).toString());
        return this;
    }
}
