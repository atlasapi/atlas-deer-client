package org.atlasapi.deer.client.query;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.atlasapi.deer.client.uri.Annotation;

import static com.google.common.base.Preconditions.checkNotNull;

public class ScheduleQuery extends Query {

    public static final String FROM_PARAM = "from";
    public static final String TO_PARAM = "to";

    public ScheduleQuery() {
        super();
    }

    public ScheduleQuery(String id) {
        super(id);
    }

    public ScheduleQuery(String... ids) {
        super(ids);
    }

    public static ScheduleQuery get() {
        return new ScheduleQuery();
    }

    public static ScheduleQuery get(String id) {
        return new ScheduleQuery(id);
    }

    public static ScheduleQuery get(String... ids) {
        return new ScheduleQuery(ids);
    }

    public ScheduleQuery addAnnotations(Annotation... annotations) {
        String joinedAnnotations = Arrays.stream(checkNotNull(annotations))
                .distinct()
                .map(Annotation::toKey)
                .collect(Collectors.joining(","));
        params.put(ANNOTATIONS_PARAM, joinedAnnotations);
        return this;
    }

    public ScheduleQuery addSource(String source) {
        params.put(SOURCE_PARAM, checkNotNull(source));
        return this;
    }

    public ScheduleQuery addFrom(ZonedDateTime fromDateTime) {
        params.put(FROM_PARAM, fromDateTime.format(DateTimeFormatter.ISO_INSTANT));
        return this;
    }

    public ScheduleQuery addTo(ZonedDateTime toDateTime) {
        params.put(TO_PARAM, toDateTime.format(DateTimeFormatter.ISO_INSTANT));
        return this;
    }
}
