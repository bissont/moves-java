package me.pims.moves.client;

import me.pims.moves.client.core.ActivityDescription;
import me.pims.moves.client.core.Summary;
import me.pims.moves.client.core.Profile;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

import java.util.List;

/**
 * See docs at https://dev.moves-app.com
 */
public interface Moves {

    @GET("/user/profile")
    public Profile profile();

    @GET("/user/summary/daily/{date}")
    public List<Summary> summary(@Path("date") String date);

    @GET("/user/summary/daily")
    public List<Summary> summary(@Query("from") String from, @Query("to") String to);

    @GET("/user/summary/daily")
    public List<Summary> summary(@Query("pastDays") Integer pastDays);

    @GET("/user/activities/daily/{date}")
    public List<Summary> activities(@Path("date") String date);

    @GET("/user/activities/daily")
    public List<Summary> activities(@Query("from") String from, @Query("to") String to);

    @GET("/user/activities/daily")
    public List<Summary> activities(@Query("pastDays") Integer pastDays);

    @GET("/user/storyline/daily/{date}")
    public List<Summary> storyline(@Path("date") String date);

    @GET("/user/storyline/daily")
    public List<Summary> storyline(@Query("from") String from, @Query("to") String to);

    @GET("/user/storyline/daily")
    public List<Summary> storyline(@Query("pastDays") Integer pastDays);

    @GET("/user/places/daily/{date}")
    public List<Summary> places(@Path("date") String date);

    @GET("/user/places/daily")
    public List<Summary> places(@Query("from") String from, @Query("to") String to);

    @GET("/user/places/daily")
    public List<Summary> places(@Query("pastDays") Integer pastDays);

    @GET("/activities")
    public List<ActivityDescription> listOfActivities();
}
