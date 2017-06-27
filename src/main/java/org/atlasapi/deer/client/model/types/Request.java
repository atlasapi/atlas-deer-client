package org.atlasapi.deer.client.model.types;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.atlasapi.deer.client.model.Utils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    private final String path;

    private final Map<String, String> parameters;

    @JsonCreator
    public Request(
            @JsonProperty("path") String path,
            @JsonProperty("parameters") Map<String, String> parameters
    ) {
        this.path = path;
        this.parameters = Utils.immutableCopyOfOrEmpty(parameters);
    }

    @JsonProperty
    public String getPath() {
        return path;
    }

    @JsonProperty
    public Map<String, String> getParameters() {
        return parameters;
    }
}
