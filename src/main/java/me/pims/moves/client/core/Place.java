package me.pims.moves.client.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Objects;
import com.google.common.base.Optional;

public class Place {

    public static class Location {
        public final Double latitude;
        public final Double longitude;

        @JsonCreator
        public Location(
                @JsonProperty("lat") final double latitude,
                @JsonProperty("lon") final double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(Location.class)
                    .add("latitude", latitude)
                    .add("longitude", longitude)
                    .toString();
        }
    }


    public enum Type {
        UNKNOWN("unknown"),
        HOME("home"),
        SCHOOL("school"),
        WORK("work");

        private String value;
        private Type(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() { return this.value; }

        @JsonCreator
        public static Type create(String val) {
            Type[] types = Type.values();
            for (Type type: types) {
                if (type.getValue().equals(val)) {
                    return type;
                }
            }

            return UNKNOWN;
        }
    }

    public final Optional<Long> id;
    public final Optional<String> name;
    public final Type type;
    public final Optional<String> foursquareId;
    public final Location location;

    @JsonCreator
    public Place(
            @JsonProperty("id") final Long id,
            @JsonProperty("name") final String name,
            @JsonProperty("type") final Type type,
            @JsonProperty("foursquareId") final String foursquareId,
            @JsonProperty("location") final Location location) {
        this.id = Optional.fromNullable(id);
        this.name = Optional.fromNullable(name);
        this.type = type;
        this.foursquareId = Optional.fromNullable(foursquareId);
        this.location = location;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(Place.class)
                .add("id", id)
                .add("name", name)
                .add("type", type)
                .add("foursquareId", foursquareId)
                .add("location", location)
                .toString();
    }
}
