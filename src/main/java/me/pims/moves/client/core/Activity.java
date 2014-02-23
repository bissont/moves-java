package me.pims.moves.client.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Objects;
import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.List;

public class Activity {

    public enum Group {
        UNKNOWN("unknown"),
        WALKING("walking"),
        RUNNING("running"),
        CYCLING("cycling"),
        TRANSPORT("transport");

        private String value;
        private Group(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() { return this.value; }

        @JsonCreator
        public static Group create(String val) {
            Group[] groups = Group.values();
            for (Group group: groups) {
                if (group.getValue().equals(val)) {
                    return group;
                }
            }

            return UNKNOWN;
        }
    }

    public final String name;
    public final Group group;
    public final Optional<Boolean> manual;
    public final Optional<String> startTime;
    public final Optional<String> endTime;
    public final Integer duration;
    public final Integer distance;
    public final Integer steps;
    public final Integer calories;
    public final List<TrackPoint> trackPoints = new ArrayList<TrackPoint>();

    @JsonCreator
    public Activity(
            @JsonProperty("activity") final String name,
            @JsonProperty("group") final String group,
            @JsonProperty("manual") final Boolean manual,
            @JsonProperty("startTime") final String startTime,
            @JsonProperty("endTime") final String endTime,
            @JsonProperty("duration") final Integer duration,
            @JsonProperty("distance") final Integer distance,
            @JsonProperty("steps") final Integer steps,
            @JsonProperty("calories") final Integer calories,
            @JsonProperty("trackPoints") final List<TrackPoint> trackPoints) {
        this.name = name;
        this.group = Group.create(group);
        this.manual = Optional.fromNullable(manual);
        this.startTime = Optional.fromNullable(startTime);
        this.endTime = Optional.fromNullable(endTime);
        this.duration = duration;
        this.distance = distance;
        this.steps = steps;
        this.calories = calories;

        if(trackPoints != null) {
            this.trackPoints.addAll(trackPoints);
        }
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(Activity.class)
                .add("name", name)
                .add("group", group)
                .add("manual", manual)
                .add("startTime", startTime)
                .add("endTime", endTime)
                .add("duration", duration)
                .add("distance", distance)
                .add("steps", steps)
                .add("calories", calories)
                .add("trackPoints", trackPoints)
                .toString();
    }
}
