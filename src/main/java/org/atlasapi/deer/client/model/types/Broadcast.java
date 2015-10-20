package org.atlasapi.deer.client.model.types;

import com.google.api.client.util.Key;

public class Broadcast {

    @Key("transmission_time")
    private String transmissionStartTime;

    public Broadcast(String transmissionStartTime) {
        this.transmissionStartTime = transmissionStartTime;
    }

    public String getTransmissionStartTime() {
        return transmissionStartTime;
    }
}
