package org.atlasapi.deer.client.model.types;

import java.util.Locale;
import java.util.Optional;

import javax.annotation.Nullable;

import org.atlasapi.media.entity.Publisher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.joda.time.DateTime;

@JsonDeserialize(builder = Review.Builder.class)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {

    private final Locale locale;
    private final String review;
    private final String author;
    private final String authorInitials;
    private final String rating;
    private final DateTime date;
    private final ReviewType reviewType;
    private final Publisher source;

    private Review(Builder builder) {
        locale = builder.locale;
        review = builder.review;
        author = builder.author;
        authorInitials = builder.authorInitials;
        rating = builder.rating;
        date = builder.date;
        reviewType = builder.reviewType;
        source = builder.source;
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

    public DateTime getDate() {
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

        private Locale locale;
        private String review;
        private String author;
        private String authorInitials;
        private String rating;
        private DateTime date;
        private ReviewType reviewType;
        private Publisher source;

        private Builder() {
        }

        public Builder withLocale(@Nullable Locale locale) {
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

        public Builder withDate(@Nullable DateTime date) {
            this.date = date;
            return this;
        }

        public Builder withReviewType(@Nullable ReviewType reviewType) {
            this.reviewType = reviewType;
            return this;
        }

        public Builder withSource(Publisher source) {
            this.source = source;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}
