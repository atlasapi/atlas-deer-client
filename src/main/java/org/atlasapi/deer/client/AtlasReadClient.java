package org.atlasapi.deer.client;

import org.atlasapi.deer.client.model.ContentResponse;
import org.atlasapi.deer.client.model.ScheduleResponse;
import org.atlasapi.deer.client.query.ContentQuery;
import org.atlasapi.deer.client.query.ScheduleQuery;

public interface AtlasReadClient {

    ContentResponse getContent(ContentQuery query);

    ScheduleResponse getSchedule(ScheduleQuery query);
}
