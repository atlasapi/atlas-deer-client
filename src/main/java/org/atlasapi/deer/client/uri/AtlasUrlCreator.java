package org.atlasapi.deer.client.uri;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import com.google.api.client.http.GenericUrl;
import com.google.common.collect.Lists;
import com.google.common.net.HostSpecifier;

public class AtlasUrlCreator {

    public static final String KEY_PARAM = "key";

    private final HostSpecifier host;
    private final String apiKey;


    public AtlasUrlCreator(HostSpecifier host, String apiKey) {
        this.host = checkNotNull(host);
        this.apiKey = checkNotNull(apiKey);
    }

    public PathStep getBuilder() {
        return new Builder();
    }

    public interface PathStep {
        FinalStep content();
        FinalStep content(String contentId);
    }

    public interface FinalStep {
        FinalStep addParams(Map<String, String> params);
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
            url.setPathParts(Lists.newArrayList(
                    "", "4", "content", checkNotNull(contentId) + ".json"
            ));
            return this;
        }

        @Override
        public FinalStep addParams(Map<String, String> params) {
            for (Map.Entry<String, String> entry : checkNotNull(params).entrySet()) {
                url.set(checkNotNull(entry.getKey()), entry.getValue());
            }
            return this;
        }

        @Override
        public GenericUrl build() {
            return url;
        }
    }
}
