package org.atlasapi.deer.client.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.atlasapi.deer.client.model.Utils;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

@JsonDeserialize(builder = Identified.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public abstract class Identified {
    private String id;
    private List<Alias> aliases;
    private List<SameAs> sameAs;
    private final Instant lastUpdated;
    private Map<String, String> customFields;

    protected Identified(Builder builder) {
        this.id = builder.id;
        this.aliases = Utils.immutableCopyOfOrEmpty(builder.aliases);
        this.sameAs = Utils.immutableCopyOfOrEmpty(builder.sameAs);
        this.lastUpdated = builder.lastUpdated;
        this.customFields = Utils.immutableCopyOfOrEmpty(builder.customFields);
    }

    protected static Builder<?> builder(Identified identified) {
        return builder(identified, new Builder());
    }

    protected static <B extends Builder<B>> B builder(Identified identified, B builder) {
        return builder
                .withId(identified.id)
                .withAliases(identified.aliases)
                .withSameAs(identified.sameAs)
                .withLastUpdated(identified.lastUpdated)
                .withCustomFields(identified.customFields)
                ;
    }

    public String getId() {
        return id;
    }

    public List<Alias> getAliases() {
        return aliases;
    }

    public List<SameAs> getSameAs() {
        return sameAs;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    public Map<String, String> getCustomFields() {
        return customFields;
    }

    @Nullable
    public String getCustomField(@NotNull String key) {
        return customFields.getOrDefault(checkNotNull(key), null);
    }

    public boolean containsCustomFieldKey(@NotNull String key) {
        return customFields.containsKey(key);
    }

    public Set<String> getCustomFieldKeys() {
        return getCustomFieldKeys(null);
    }

    public Set<String> getCustomFieldKeys(@Nullable String regex) {
        if(regex == null) {
            return customFields.keySet();
        }
        Pattern regexPattern = Pattern.compile(regex);
        return customFields.keySet()
                .stream()
                .filter(key -> regexPattern.matcher(key).matches())
                .collect(Collectors.toSet());
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @SuppressWarnings("unchecked")
    public static class Builder<B extends Builder<B>> {
        private String id;
        private List<Alias> aliases;
        private List<SameAs> sameAs;
        private Instant lastUpdated;
        private Map<String, String> customFields;

        public B withId(String val) {
            id = val;
            return (B) this;
        }

        public B withAliases(List<Alias> val) {
            aliases = val;
            return (B) this;
        }

        public B withSameAs(List<SameAs> val) {
            sameAs = val;
            return (B) this;
        }

        public B withLastUpdated(Instant lastUpdated) {
            this.lastUpdated = lastUpdated;
            return (B) this;
        }

        public B withCustomFields(Map<String, String> customFields) {
            this.customFields = customFields;
            return (B) this;
        }
    }
}
