package me.pims.moves.client;

import com.fasterxml.jackson.core.type.TypeReference;
import me.pims.moves.client.core.Activity;
import me.pims.moves.client.core.ActivityDescription;
import me.pims.moves.client.core.ActivityDescription.Unit;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ActivityDescriptionTest extends BaseDeserializationTest {

    @Test
    public void deserializeTest() throws Exception {
        final String json = getJSON("api-responses/activities.json");

        final List<ActivityDescription> activities = objectMapper.readValue(json, new TypeReference<List<ActivityDescription>>(){});
        assertTrue(activities.size() > 0);
        ActivityDescription firstActivityDescription = activities.get(0);
        assertThat(firstActivityDescription.group, equalTo(Activity.Group.UNKNOWN));
        assertThat(firstActivityDescription.name, equalTo("aerobics"));
        assertThat(firstActivityDescription.units, hasItems(Unit.DURATION, Unit.CALORIES));

    }
}
