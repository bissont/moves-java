package me.pims.moves.client.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class TrackPoint {

    public final Double latitude;
    public final Double longitude;
    public final String time;

    @JsonCreator
    public TrackPoint(
            @JsonProperty("lat") final Double latitude,
            @JsonProperty("lon") final Double longitude,
            @JsonProperty("time") final String time) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(TrackPoint.class)
                .add("latitude", latitude)
                .add("longitude", longitude)
                .add("time", time)
                .toString();
    }
}
