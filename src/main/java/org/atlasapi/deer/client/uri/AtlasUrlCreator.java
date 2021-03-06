package org.atlasapi.deer.client.uri;

import com.google.api.client.http.GenericUrl;
import com.google.common.collect.Lists;
import com.google.common.net.HostAndPort;

import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class AtlasUrlCreator {

    public static final String API_VERSION = "4";
    public static final String CONTENT_JSON = "content.json";
    public static final String SCHEDULE_JSON = "schedules.json";
    public static final String TOPIC_JSON = "topics.json";
    public static final String CHANNEL_JSON = "channels.json";
    public static final String CHANNEL_GROUPS_JSON = "channel_groups.json";
    public static final String KEY_PARAM = "key";
    public static final String ID_PARAM = "id";
    public static final String IDS_PARAM = "ids";

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
        FinalStep schedule(String channelId);
        FinalStep topic();
        FinalStep topic(String topicId);
        FinalStep channel();
        FinalStep channel(String channelId);
        FinalStep channelGroup();
        FinalStep channelGroup(String channelGroupId);
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
            url.setPathParts(Lists.newArrayList("", API_VERSION, CONTENT_JSON));
            return this;
        }

        public FinalStep schedule() {
            url.setPathParts(Lists.newArrayList("", API_VERSION, SCHEDULE_JSON));
            return this;
        }

        public FinalStep topic() {
            url.setPathParts(Lists.newArrayList("", API_VERSION, TOPIC_JSON));
            return this;
        }
        
        public FinalStep channel() {
            url.setPathParts(Lists.newArrayList("", API_VERSION, CHANNEL_JSON));
            return this;
        }

        public FinalStep channelGroup() {
            url.setPathParts(Lists.newArrayList("", API_VERSION, CHANNEL_GROUPS_JSON));
            return this;
        }

        @Override
        public FinalStep content(String contentId) {
            return content().addParam(ID_PARAM, contentId);
        }

        @Override
        public FinalStep schedule(String channelId) {
            return schedule().addParam(ID_PARAM, channelId);
        }

        @Override
        public FinalStep topic(String topicId) {
            return topic().addParam(ID_PARAM, topicId);
        }
        
        @Override
        public FinalStep channel(String channelId) {
            return channel().addParam(ID_PARAM, channelId);
        }

        @Override
        public FinalStep channelGroup(String channelGroupId) {
            return channelGroup().addParam(IDS_PARAM, channelGroupId);
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
