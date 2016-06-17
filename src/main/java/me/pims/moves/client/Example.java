package me.pims.moves.client;

import me.pims.moves.client.core.ActivityDescription;
import me.pims.moves.client.core.Summary;
import me.pims.moves.client.core.Profile;

import java.util.List;

public class Example {

    public static void main(String[] args) throws Exception {

        // On mac set access token in .profile with launchctl setenve VAR val
        final String token = System.getenv("ACCESS_TOKEN");

        final Moves moves = new MovesBuilder().setToken(token).build();

        final Profile profile = moves.profile();

		final List<Summary> summary = moves.summary("2016-05-15");
		final List<Summary> summaryBetween = moves.summary("2016-06-14", "2016-06-15");
		final List<Summary> past30days = moves.summary(30);

		final List<Summary> activities = moves.activities("2016-06-14");
		final List<Summary> storyline = moves.storyline("2016-06-14");
		final List<Summary> places = moves.places("2016-06-14");
		        
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
