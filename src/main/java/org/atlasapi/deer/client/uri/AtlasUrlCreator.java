package org.atlasapi.deer.client.uri;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.google.api.client.http.GenericUrl;
import com.google.common.collect.Lists;
import com.google.common.net.HostSpecifier;

public class AtlasUrlCreator {

    public static final String KEY_PARAM = "key";
    public static final String ID_PARAM = "id";
    public static final String ANNOTATIONS_PARAM = "annotations";
    public static final String ALIASES_NAMESPACE_PARAM = "aliases.namespace";
    public static final String ALIASES_VALUE_PARAM = "aliases.value";

    private final HostSpecifier host;
    private final String apiKey;


    public AtlasUrlCreator(HostSpecifier host, String apiKey) {
        this.host = host;
        this.apiKey = apiKey;
    }

    public PathStep getBuilder() {
        return new Builder();
    }

    public interface PathStep {
        FinalStep content();
        FinalStep content(String contentId);
    }

    public interface FinalStep {
        FinalStep addIds(String... ids);
        FinalStep addAnnotations(Annotation... annotations);
        FinalStep addAlias(String namespace, String value);
        GenericUrl build();
    }

    public class Builder implements PathStep, FinalStep {

        private final GenericUrl url;

        private Builder() {
            url = new GenericUrl();
            url.setScheme("https");
            url.setHost(host.toString());
            url.set(KEY_PARAM, apiKey);
        }

        @Override
        public FinalStep content() {
            url.setPathParts(Lists.newArrayList("", "4", "content.json"));
            return this;
        }

        @Override
        public FinalStep content(String contentId) {
            url.setPathParts(Lists.newArrayList("", "4", "content", contentId + ".json"));
            return this;
        }

        @Override
        public FinalStep addIds(String... ids) {
            url.set(ID_PARAM, String.join(",", ids));
            return this;
        }

        @Override
        public FinalStep addAnnotations(Annotation... annotations) {
            String joinedAnnotations = Arrays.stream(annotations)
                    .map(Annotation::toKey)
                    .collect(Collectors.joining(","));
            url.set(ANNOTATIONS_PARAM, joinedAnnotations);
            return this;
        }

        @Override
        public FinalStep addAlias(String namespace, String value) {
            url.set(ALIASES_NAMESPACE_PARAM, namespace);
            url.set(ALIASES_VALUE_PARAM, value);
            return this;
        }

        @Override
        public GenericUrl build() {
            return url;
        }
    }
}
