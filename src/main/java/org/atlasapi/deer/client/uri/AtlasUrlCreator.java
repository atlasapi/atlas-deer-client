package org.atlasapi.deer.client.uri;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import com.google.api.client.http.GenericUrl;
import com.google.common.collect.Lists;
import com.google.common.net.HostAndPort;

public class AtlasUrlCreator {

    public static final String KEY_PARAM = "key";

    private final String scheme;
    private final HostAndPort host;
    private final String apiKey;


    public AtlasUrlCreator(String scheme, HostAndPort host, String apiKey) {
        this.scheme = checkNotNull(scheme);
        this.host = checkNotNull(host);
        this.apiKey = checkNotNull(apiKey);

        checkArgument(this.scheme.equals("http") || this.scheme.equals("https"));
    }

    public PathStep getBuilder() {
        return new Builder();
    }

    public interface PathStep {
        FinalStep content();
        FinalStep content(String contentId);
    }

    public interface FinalStep {
        FinalStep addParam(String key, String value);
        FinalStep addParams(Map<String, String> params);
        GenericUrl build();
    }

    public class Builder implements PathStep, FinalStep {

        private final GenericUrl url;

        private Builder() {
            url = new GenericUrl();
            url.setScheme(scheme);
            url.setHost(host.getHostText());
            if (host.hasPort()) {
                url.setPort(host.getPort());
            }
            url.set(KEY_PARAM, apiKey);
        }

        @Override
        public FinalStep content() {
            url.setPathParts(Lists.newArrayList("", "4", "content.json"));
            return this;
        }

        @Override
        public FinalStep content(String contentId) {
            return content().addParam("id", contentId);
        }

        @Override
        public FinalStep addParam(String key, String value) {
            url.set(checkNotNull(key), value);
            return this;
        }

        @Override
        public FinalStep addParams(Map<String, String> params) {
            for (Map.Entry<String, String> entry : checkNotNull(params).entrySet()) {
                addParam(entry.getKey(), entry.getValue());
            }
            return this;
        }

        @Override
        public GenericUrl build() {
            return url;
        }
    }
}
