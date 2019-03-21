package org.atlasapi.deer.client.query;

import org.atlasapi.deer.client.uri.Annotation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkNotNull;

public class ChannelQuery extends Query {
    
    public static final String ALIASES_NAMESPACE_PARAM = "aliases.namespace";
    public static final String ALIASES_VALUE_PARAM = "aliases.value";
    
    private ChannelQuery() {
        super();       
    }
    
    private ChannelQuery(String id) {
        super(id);
    }
    
    private ChannelQuery(String... ids) {
        super(ids);
    }
    
    private ChannelQuery(List<String> ids) {
        super(ids);
    }
    
    public static ChannelQuery get() {
        return new ChannelQuery();
    }

    public static ChannelQuery get(String id) {
        return new ChannelQuery(id);
    }

    public static ChannelQuery get(String... ids) {
        return new ChannelQuery(ids);
    }

    public static ChannelQuery get(List<String> ids) {
        return new ChannelQuery(ids);
    }
    
    public ChannelQuery addAnnotations(Collection<Annotation> annotations) {
        return addAnnotations(checkNotNull(annotations).stream());
    }

    public ChannelQuery addAnnotations(Annotation... annotations) {
        return addAnnotations(Arrays.stream(checkNotNull(annotations)));
    }

    private ChannelQuery addAnnotations(Stream<Annotation> annotations) {
        params.put(
                ANNOTATIONS_PARAM,
                annotations
                        .distinct()
                        .map(Annotation::toKey)
                        .collect(Collectors.joining(","))
        );
        return this;
    }

    public ChannelQuery addAlias(String namespace, String value) {
        params.put(ALIASES_NAMESPACE_PARAM, checkNotNull(namespace));
        params.put(ALIASES_VALUE_PARAM, checkNotNull(value));
        return this;
    }

    public ChannelQuery addSource(String source) {
        params.put(SOURCE_PARAM, checkNotNull(source));
        return this;
    }
}
