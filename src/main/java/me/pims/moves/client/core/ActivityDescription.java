package me.pims.moves.client.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;

public class ActivityDescription {

    public enum Unit {
        DURATION("duration"),
        CALORIES("calories"),
        DISTANCE("distance"),
        STEPS("steps");

        private String value;
        private Unit(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() { return this.value; }

        @JsonCreator
        public static Unit create(String val) {
            Unit[] types = Unit.values();
            for (Unit type: types) {
                if (type.getValue().equals(val)) {
                    return type;
                }
            }

            throw new IllegalArgumentException(String.format("%s is not recognized as a valid Unit ", val));
        }
    }

    public final String name;
    public final Activity.Group group;
    public final Boolean geo;
    public final Boolean place;
    public final String color;
    public final List<Unit> units = new ArrayList<Unit>();

    @JsonCreator
    public ActivityDescription(
            @JsonProperty("activity") String name,
            @JsonProperty("geo") Boolean geo,
            @JsonProperty("group") String group,
            @JsonProperty("place") Boolean place,
            @JsonProperty("color") String color,
            @JsonProperty("units") String units) {

        this.name = name;
        this.group = Activity.Group.create(group);
        this.geo = geo;
        this.place = place;
        this.color = color;

        Iterable<String> iterable = Splitter.on(",").omitEmptyStrings().split(units);
        for(String unit : iterable) {
            this.units.add(Unit.create(unit));
        }
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(ActivityDescription.class)
                .add("name", name)
                .add("group", group)
                .add("geo", geo)
                .add("place", place)
                .add("color", color)
                .add("units", units)
                .toString();
    }
}
