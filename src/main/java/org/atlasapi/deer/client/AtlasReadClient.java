package org.atlasapi.deer.client;

import org.atlasapi.deer.client.model.ChannelResponse;
import org.atlasapi.deer.client.model.ContentResponse;
import org.atlasapi.deer.client.model.ScheduleResponse;
import org.atlasapi.deer.client.model.TopicResponse;
import org.atlasapi.deer.client.query.ChannelQuery;
import org.atlasapi.deer.client.query.ContentQuery;
import org.atlasapi.deer.client.query.ScheduleQuery;

import com.google.api.client.http.HttpHeaders;
import com.google.common.annotations.Beta;
import org.atlasapi.deer.client.query.TopicQuery;

@Beta
public interface AtlasReadClient {

    /**
     * Execute GET on the content endpoint
     * @param query content query
     * @return response body
     */
    ContentResponse getContent(ContentQuery query);

    /**
     * Execute HEAD on the content endpoint
     * @param query content query
     * @return response headers
     */
    HttpHeaders headContent(ContentQuery query);

    /**
     * Execute GET on the schedule endpoint
     * @param query schedule query
     * @return response body
     */
    ScheduleResponse getSchedule(ScheduleQuery query);

    /**
     * Execute GET on the topics endpoint
     * @param query topic query
     * @return response body
     */
    public TopicResponse getTopic(TopicQuery query);

    /**
     * Execute GET on the channel endpoint
     * @param query channel query
     * @return response body
     */
    public ChannelResponse getChannel(ChannelQuery query);
}
