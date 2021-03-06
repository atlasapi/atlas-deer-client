package org.atlasapi.deer.client.model.types;

import java.time.Instant;
import java.util.Currency;
import java.util.List;
import java.util.Set;

import com.metabroadcast.common.media.MimeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.atlasapi.deer.client.model.Utils;

@JsonDeserialize(builder = Location.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private final String uri;
    private final List<Alias> aliases;
    private final Boolean available;
    private final Integer duration;
    private final Boolean transportIsLive;
    private final TransportType transportType;
    private final TransportSubType transportSubType;
    private final String embedId;
    private final String embedCode;
    private final Provider provider;

    private final Instant availabilityStart;
    private final Instant availabilityEnd;
    private final List<String> availableCountries;
    private final Instant drmPlayableFrom;
    private final Currency currency;
    private final Integer amount;
    private final String revenueContract;
    private final List<String> subscriptionPackages;
    private final List<Pricing> pricing;

    private final Boolean containsAdvertising;
    private final Integer advertisingDuration;
    private final Integer bitRate;
    private final Integer audioBitRate;
    private final Integer audioChannels;
    private final MimeType audioCoding;
    private final String videoAspectRatio;
    private final Integer videoBitRate;
    private final MimeType videoCoding;
    private final Float videoFrameRate;
    private final Integer videoHorizontalSize;
    private final Boolean videoProgressiveScan;
    private final Integer videoVerticalSize;
    private final Long dataSize;
    private final MimeType dataContainerFormat;
    private final Source source;
    private final String distributor;
    private final Boolean hasDog;
    private final Boolean is3d;
    private final Quality quality;
    private final String qualityDetail;
    private final String versionId;

    private Location(Builder builder) {
        this.uri = builder.uri;
        this.aliases = Utils.immutableCopyOfOrEmpty(builder.aliases);
        this.available = builder.available;
        this.duration = builder.duration;
        this.transportIsLive = builder.transportIsLive;
        this.transportType = (builder.transportType == null)
                ? null
                : TransportType.fromString(builder.transportType);
        this.transportSubType = (builder.transportSubType == null)
                ? null
                : TransportSubType.fromString(builder.transportSubType);
        this.embedId = builder.embedId;
        this.embedCode = builder.embedCode;
        this.provider = builder.provider;
        this.availabilityStart = builder.availabilityStart;
        this.availabilityEnd = builder.availabilityEnd;
        this.availableCountries =  Utils.immutableCopyOfOrEmpty(builder.availableCountries);
        this.drmPlayableFrom = builder.drmPlayableFrom;
        this.currency = builder.currency;
        this.amount = builder.amount;
        this.revenueContract = builder.revenueContract;
        this.subscriptionPackages = Utils.immutableCopyOfOrEmpty(builder.subscriptionPackages);
        this.pricing = Utils.immutableCopyOfOrEmpty(builder.pricing);
        this.containsAdvertising = builder.containsAdvertising;
        this.advertisingDuration = builder.advertisingDuration;
        this.bitRate = builder.bitRate;
        this.audioBitRate = builder.audioBitRate;
        this.audioChannels = builder.audioChannels;
        this.audioCoding = (builder.audioCoding == null)
                ? null
                : MimeType.fromString(builder.audioCoding);
        this.videoAspectRatio = builder.videoAspectRatio;
        this.videoBitRate = builder.videoBitRate;
        this.videoCoding = (builder.videoCoding == null)
                ? null
                : MimeType.fromString(builder.videoCoding);
        this.videoFrameRate = builder.videoFrameRate;
        this.videoHorizontalSize = builder.videoHorizontalSize;
        this.videoProgressiveScan = builder.videoProgressiveScan;
        this.videoVerticalSize = builder.videoVerticalSize;
        this.dataSize = builder.dataSize;
        this.dataContainerFormat = (builder.dataContainerFormat == null)
                ? null
                : MimeType.fromString(builder.dataContainerFormat);
        this.source = builder.source;
        this.distributor = builder.distributor;
        this.hasDog = builder.hasDog;
        this.is3d = builder.is3d;
        this.quality = builder.quality;
        this.qualityDetail = builder.qualityDetail;
        this.versionId = builder.versionId;
    }

    public String getUri() {
        return uri;
    }

    public List<Alias> getAliases() {
        return aliases;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Integer getDuration() {
        return duration;
    }

    public Boolean getTransportIsLive() {
        return transportIsLive;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public TransportSubType getTransportSubType() {
        return transportSubType;
    }

    public String getEmbedId() {
        return embedId;
    }

    public String getEmbedCode() {
        return embedCode;
    }

    public Provider getProvider() {
        return provider;
    }

    public Instant getAvailabilityStart() {
        return availabilityStart;
    }

    public Instant getAvailabilityEnd() {
        return availabilityEnd;
    }

    public List<String> getAvailableCountries() {
        return availableCountries;
    }

    public Instant getDrmPlayableFrom() {
        return drmPlayableFrom;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getRevenueContract() {
        return revenueContract;
    }

    public List<String> getSubscriptionPackages() {
        return subscriptionPackages;
    }

    public List<Pricing> getPricing() {
        return pricing;
    }

    public Boolean getContainsAdvertising() {
        return containsAdvertising;
    }

    public Integer getAdvertisingDuration() {
        return advertisingDuration;
    }

    public Integer getBitRate() {
        return bitRate;
    }

    public Integer getAudioBitRate() {
        return audioBitRate;
    }

    public Integer getAudioChannels() {
        return audioChannels;
    }

    public MimeType getAudioCoding() {
        return audioCoding;
    }

    public String getVideoAspectRatio() {
        return videoAspectRatio;
    }

    public Integer getVideoBitRate() {
        return videoBitRate;
    }

    public MimeType getVideoCoding() {
        return videoCoding;
    }

    public Float getVideoFrameRate() {
        return videoFrameRate;
    }

    public Integer getVideoHorizontalSize() {
        return videoHorizontalSize;
    }

    public Boolean getVideoProgressiveScan() {
        return videoProgressiveScan;
    }

    public Integer getVideoVerticalSize() {
        return videoVerticalSize;
    }

    public Long getDataSize() {
        return dataSize;
    }

    public MimeType getDataContainerFormat() {
        return dataContainerFormat;
    }

    public Source getSource() {
        return source;
    }

    public String getDistributor() {
        return distributor;
    }

    public Boolean getHasDog() {
        return hasDog;
    }

    public Boolean getIs3d() {
        return is3d;
    }

    public Quality getQuality() {
        return quality;
    }

    public String getQualityDetail() {
        return qualityDetail;
    }

    public String getVersionId() {
        return versionId;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {

        private String uri;
        private List<Alias> aliases;
        private Boolean available;
        private Instant availabilityStart;
        private Instant availabilityEnd;
        private List<String> availableCountries;
        private Instant drmPlayableFrom;
        private Currency currency;
        private Integer amount;
        private String revenueContract;
        private List<String> subscriptionPackages;
        private List<Pricing> pricing;
        private Boolean containsAdvertising;
        private Integer advertisingDuration;
        private Integer bitRate;
        private Integer audioBitRate;
        private Integer audioChannels;
        private String audioCoding;
        private String videoAspectRatio;
        private Integer videoBitRate;
        private String videoCoding;
        private Float videoFrameRate;
        private Integer videoHorizontalSize;
        private Boolean videoProgressiveScan;
        private Integer videoVerticalSize;
        private Long dataSize;
        private String dataContainerFormat;
        private Source source;
        private String distributor;
        private Boolean hasDog;
        private Boolean is3d;
        private Quality quality;
        private String qualityDetail;
        private String versionId;
        private Integer duration;
        private Boolean transportIsLive;
        private String transportType;
        private String transportSubType;
        private String embedId;
        private String embedCode;
        private Provider provider;

        public Builder() {
        }

        public Builder withUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder withAliases(List<Alias> aliases) {
            this.aliases = aliases;
            return this;
        }

        public Builder withAvailable(Boolean available) {
            this.available = available;
            return this;
        }

        public Builder withAvailabilityStart(Instant availabilityStart) {
            this.availabilityStart = availabilityStart;
            return this;
        }

        public Builder withAvailabilityEnd(Instant availabilityEnd) {
            this.availabilityEnd = availabilityEnd;
            return this;
        }

        public Builder withAvailableCountries(List<String> availableCountries) {
            this.availableCountries = availableCountries;
            return this;
        }

        public Builder withDrmPlayableFrom(Instant drmPlayableFrom) {
            this.drmPlayableFrom = drmPlayableFrom;
            return this;
        }

        public Builder withCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public Builder withAmount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public Builder withRevenueContract(String revenueContract) {
            this.revenueContract = revenueContract;
            return this;
        }

        public Builder withSubscriptionPackages(List<String> subscriptionPackages) {
            this.subscriptionPackages = subscriptionPackages;
            return this;
        }

        public Builder withPricing(List<Pricing> pricing) {
            this.pricing = pricing;
            return this;
        }

        public Builder withContainsAdvertising(Boolean containsAdvertising) {
            this.containsAdvertising = containsAdvertising;
            return this;
        }

        public Builder withAdvertisingDuration(Integer advertisingDuration) {
            this.advertisingDuration = advertisingDuration;
            return this;
        }

        public Builder withBitRate(Integer bitRate) {
            this.bitRate = bitRate;
            return this;
        }

        public Builder withAudioBitRate(Integer audioBitRate) {
            this.audioBitRate = audioBitRate;
            return this;
        }

        public Builder withAudioChannels(Integer audioChannels) {
            this.audioChannels = audioChannels;
            return this;
        }

        public Builder withAudioCoding(String audioCoding) {
            this.audioCoding = audioCoding;
            return this;
        }

        public Builder withVideoAspectRatio(String videoAspectRatio) {
            this.videoAspectRatio = videoAspectRatio;
            return this;
        }

        public Builder withVideoBitRate(Integer videoBitRate) {
            this.videoBitRate = videoBitRate;
            return this;
        }

        public Builder withVideoCoding(String videoCoding) {
            this.videoCoding = videoCoding;
            return this;
        }

        public Builder withVideoFrameRate(Float videoFrameRate) {
            this.videoFrameRate = videoFrameRate;
            return this;
        }

        public Builder withVideoHorizontalSize(Integer videoHorizontalSize) {
            this.videoHorizontalSize = videoHorizontalSize;
            return this;
        }

        public Builder withVideoProgressiveScan(Boolean videoProgressiveScan) {
            this.videoProgressiveScan = videoProgressiveScan;
            return this;
        }

        public Builder withVideoVerticalSize(Integer videoVerticalSize) {
            this.videoVerticalSize = videoVerticalSize;
            return this;
        }

        public Builder withDataSize(Long dataSize) {
            this.dataSize = dataSize;
            return this;
        }

        public Builder withDataContainerFormat(String dataContainerFormat) {
            this.dataContainerFormat = dataContainerFormat;
            return this;
        }

        public Builder withSource(Source source) {
            this.source = source;
            return this;
        }

        public Builder withDistributor(String distributor) {
            this.distributor = distributor;
            return this;
        }

        public Builder withHasDog(Boolean hasDog) {
            this.hasDog = hasDog;
            return this;
        }

        public Builder withIs3d(Boolean is3d) {
            this.is3d = is3d;
            return this;
        }

        public Builder withQuality(Quality quality) {
            this.quality = quality;
            return this;
        }

        public Builder withQualityDetail(String qualityDetail) {
            this.qualityDetail = qualityDetail;
            return this;
        }

        public Builder withVersionId(String versionId) {
            this.versionId = versionId;
            return this;
        }

        public Builder withDuration(Integer duration) {
            this.duration = duration;
            return this;
        }

        public Builder withTransportIsLive(Boolean transportIsLive) {
            this.transportIsLive = transportIsLive;
            return this;
        }

        public Builder withTransportType(String transportType) {
            this.transportType = transportType;
            return this;
        }

        public Builder withTransportSubType(String transportSubType) {
            this.transportSubType = transportSubType;
            return this;
        }

        public Builder withEmbedId(String embedId) {
            this.embedId = embedId;
            return this;
        }

        public Builder withEmbedCode(String embedCode) {
            this.embedCode = embedCode;
            return this;
        }

        public Builder withProvider(Provider provider) {
            this.provider = provider;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}
