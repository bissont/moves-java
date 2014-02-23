package me.pims.moves.client.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Objects;
import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.List;

public class Segment {
    public enum Type {
        MOVE("move"),
        PLACE("place");

        private String value;
        private Type(String type) {
            this.value = type;
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

            throw new IllegalArgumentException(String.format("%s is not recognized as a valid Segment Type", val));
        }

    }
    public final String type;
    public final String startTime;
    public final String endTime;
    public final Optional<Place> place;
    public final List<Activity> activities = new ArrayList<Activity>();
    public final Optional<String> lastUpdate;

    public Segment(
            @JsonProperty("type") final String type,
            @JsonProperty("startTime") final String startTime,
            @JsonProperty("endTime") final String endTime,
            @JsonProperty("place") final Place place,
            @JsonProperty("activities") final List<Activity> activities,
            @JsonProperty("lastUpdate") final String lastUpdate) {
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.place = Optional.fromNullable(place);

        if(activities != null) {
            this.activities.addAll(activities);
        }

        this.lastUpdate = Optional.fromNullable(lastUpdate);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(Segment.class)
                .add("type", type)
                .add("startTime", startTime)
                .add("endTime", endTime)
                .add("place", place)
                .add("activities", activities)
                .add("lastUpdate", lastUpdate)
                .toString();
    }
}
