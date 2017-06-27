package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Broadcast {

    private final String transmissionStartTime;

    @JsonCreator
    public Broadcast(
            @JsonProperty("tranmission_time") String transmissionStartTime
    ) {
        this.transmissionStartTime = transmissionStartTime;
    }

    @JsonProperty("transmission_time")
    public String getTransmissionStartTime() {
        return transmissionStartTime;
    }
}
