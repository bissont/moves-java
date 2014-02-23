package me.pims.moves.client.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * See doc at https://dev.moves-app.com/docs/api_profile
 *
 */
@JsonDeserialize(builder = Profile.Builder.class)
public class Profile {

    public static class Localization {
        public final String language;
        public final String locale;
        public final Integer firstWeekDay;
        public final Boolean metric;

        @JsonCreator
        public Localization(
                @JsonProperty("language") final String language,
                @JsonProperty("locale") final String locale,
                @JsonProperty("firstWeekDay") final Integer firstWeekDay,
                @JsonProperty("metric") final Boolean metric) {
            this.language = language;
            this.locale = locale;
            this.firstWeekDay = firstWeekDay;
            this.metric = metric;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(Localization.class)
                    .add("language", language)
                    .add("locale", locale)
                    .add("firstWeekDay", firstWeekDay)
                    .add("metric", metric)
                    .toString();
        }
    }

    public static class TimeZone {
        public final String id;
        public final Integer offset;

        @JsonCreator
        public TimeZone(
                @JsonProperty("id") final String id,
                @JsonProperty("offset") final Integer offset) {
            this.id = id;
            this.offset = offset;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(TimeZone.class)
                    .add("id", id)
                    .add("offset", offset)
                    .toString();
        }
    }

    public static class InnerProfile {
        public final Boolean caloriesAvailable;
        public final String platform;
        public final String firstDate;
        public final TimeZone currentTimeZone;
        public final Localization localization;

        @JsonCreator
        public InnerProfile(
                @JsonProperty("caloriesAvailable") final Boolean caloriesAvailable,
                @JsonProperty("platform") final String platform,
                @JsonProperty("firstDate") final String firstDate,
                @JsonProperty("currentTimeZone") final TimeZone currentTimeZone,
                @JsonProperty("localization") final Localization localization) {
            this.caloriesAvailable = caloriesAvailable;
            this.platform = platform;
            this.firstDate = firstDate;
            this.currentTimeZone = currentTimeZone;
            this.localization = localization;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(InnerProfile.class)
                    .add("caloriesAvailable", caloriesAvailable)
                    .add("platform", platform)
                    .add("firstDate", firstDate)
                    .add("currentTimeZone", currentTimeZone)
                    .add("localization", localization)
                    .toString();
        }
    }


    @JsonProperty("userId")
    public final Long userId;

    @JsonProperty("profile")
    public final InnerProfile profile;

    public Profile(final Long userId, final InnerProfile profile) {
        this.userId = userId;
        this.profile = profile;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(Profile.class)
                .add("userId", userId)
                .add("profile", profile)
                .toString();
    }


    public static class Builder {
        private Long userId;
        private InnerProfile profile;

        @JsonProperty("userId")
        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        @JsonProperty("profile")
        public Builder setProfile(InnerProfile profile) {
            this.profile = profile;
            return this;
        }

        public Profile build() {
            checkNotNull(userId, "userId can not be null");
            checkNotNull(profile, "profile can not be null");
            return new Profile(userId, profile);
        }
    }
}
