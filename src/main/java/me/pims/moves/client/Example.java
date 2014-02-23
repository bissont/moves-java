package me.pims.moves.client;

import me.pims.moves.client.core.ActivityDescription;
import me.pims.moves.client.core.Summary;
import me.pims.moves.client.core.Profile;

import java.util.List;

public class Example {

    public static void main(String[] args) throws Exception {

        final String token = System.getenv("ACCESS_TOKEN");

        Moves moves = new MovesBuilder().setToken(token).build();

        final Profile profile = moves.profile();

        final List<Summary> summary = moves.summary("2013-11-15");
        final List<Summary> summaryBetween = moves.summary("2013-11-14", "2013-11-15");
        final List<Summary> past30days = moves.summary(30);

        final List<Summary> activities = moves.activities("2013-11-14");
        final List<Summary> storyline = moves.storyline("2013-11-14");
        final List<Summary> places = moves.places("2013-11-14");

        final List<ActivityDescription> descriptions = moves.listOfActivities();

        System.out.println(summary);
        System.out.println(summaryBetween);
        System.out.println(past30days);

        System.out.println(activities);
        System.out.println(profile);

        System.out.println(storyline);
        System.out.println(places);
        System.out.println(descriptions);
    }
}
