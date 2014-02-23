package me.pims.moves.client;

import me.pims.moves.client.core.Profile;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ProfileTest extends BaseDeserializationTest {

    @Test
    public void deserializeTest() throws Exception {
        final String json = getJSON("api-responses/profile.json");

        final Profile profile = objectMapper.readValue(json, Profile.class);
        assertThat(profile.userId, equalTo(23138311640030064L));
        assertThat(profile.profile.firstDate, equalTo("20121211"));
        assertThat(profile.profile.currentTimeZone.id, equalTo("Europe/Helsinki"));
        assertThat(profile.profile.localization.language, equalTo("en"));
        assertThat(profile.profile.caloriesAvailable, equalTo(Boolean.TRUE));
        assertThat(profile.profile.platform, equalTo("ios"));
    }
}
