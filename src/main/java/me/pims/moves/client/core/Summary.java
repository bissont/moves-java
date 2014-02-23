package me.pims.moves.client.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.List;

/**
 * See doc at https://dev.moves-app.com/docs/api_summaries
 */
public class Summary {

    public final String date;
    public final List<Activity> activities = new ArrayList<Activity>();
    public final List<Segment> segments = new ArrayList<Segment>();
    public final Integer caloriesIdle;
    public final Optional<String> lastUpdate;

    @JsonCreator
    public Summary(
            @JsonProperty("date") final String date,
            @JsonProperty("summary") final List<Activity> activities,
            @JsonProperty("segments") final List<Segment> segments,
            @JsonProperty("caloriesIdle") final Integer caloriesIdle,
            @JsonProperty("lastUpdate") final String lastUpdate) {
        this.date = date;

        if(activities != null) {
            this.activities.addAll(activities);
        }

        if(segments != null) {
            this.segments.addAll(segments);
        }

        this.caloriesIdle = (caloriesIdle == null) ? 0 : caloriesIdle;
        this.lastUpdate = Optional.fromNullable(lastUpdate);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(Summary.class)
                .add("date", date)
                .add("activities", activities)
                .add("segments", segments)
                .add("caloriesIdle", caloriesIdle)
                .add("lastUpdate", lastUpdate)
                .toString();
    }
}
