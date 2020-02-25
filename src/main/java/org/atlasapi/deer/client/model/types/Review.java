package org.atlasapi.deer.client.model.types;

import java.time.Instant;
import java.util.Locale;

import javax.annotation.Nullable;

import org.atlasapi.media.entity.Publisher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Review.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {

    private final Locale locale;
    private final String review;
    private final String author;
    private final String authorInitials;
    private final String rating;
    private final Instant date;
    private final ReviewType reviewType;
    private final Publisher source;

    private Review(Builder builder) {
        locale = (builder.locale == null)
                ? null
                : Locale.forLanguageTag(builder.locale);
        review = builder.review;
        author = builder.author;
        authorInitials = builder.authorInitials;
        rating = builder.rating;
        date = builder.date;
        reviewType = (builder.reviewType == null)
                ? null
                : ReviewType.fromKey(builder.reviewType);
        source = (builder.source == null)
                ? null
                : Publisher.fromKey(builder.source).requireValue();
    }

    public Locale getLocale() {
        return locale;
    }

    public String getReview() {
        return review;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthorInitials() {
        return authorInitials;
    }

    public String getRating() {
        return rating;
    }

    public Instant getDate() {
        return date;
    }

    public ReviewType getReviewType() {
        return reviewType;
    }

    public Publisher getSource() {
        return source;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder()
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {

        private String locale;
        private String review;
        private String author;
        private String authorInitials;
        private String rating;
        private Instant date;
        private String reviewType;
        private String source;

        private Builder() {
        }

        public Builder withLocale(@Nullable String locale) {
            this.locale = locale;
            return this;
        }

        public Builder withReview(String review) {
            this.review = review;
            return this;
        }

        public Builder withAuthor(@Nullable String author) {
            this.author = author;
            return this;
        }

        public Builder withAuthorInitials(@Nullable String authorInitials) {
            this.authorInitials = authorInitials;
            return this;
        }

        public Builder withRating(@Nullable String rating) {
            this.rating = rating;
            return this;
        }

        public Builder withDate(@Nullable Instant date) {
            this.date = date;
            return this;
        }

        public Builder withReviewType(@Nullable String reviewType) {
            this.reviewType = reviewType;
            return this;
        }

        public Builder withSource(String source) {
            this.source = source;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}
