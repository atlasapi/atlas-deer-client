package org.atlasapi.deer.client.model.types;

import java.util.Map;

import org.atlasapi.deer.client.model.Utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
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

    public String getPath() {
        return path;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }
}
