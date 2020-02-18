package org.atlasapi.deer.client.model.types;

public enum TransportSubType {

    HTTP,
    RTSP,
    ITUNES,
    BRIGHTCOVE;

    public String toString() {
        return name().toLowerCase();
    }

    public static TransportSubType fromString(String s) {
        return valueOf(s.toUpperCase());
    }

    ;
}
