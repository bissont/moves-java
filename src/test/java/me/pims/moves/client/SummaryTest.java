package me.pims.moves.client;

import com.fasterxml.jackson.core.type.TypeReference;
import me.pims.moves.client.core.Activity;
import me.pims.moves.client.core.Summary;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SummaryTest extends BaseDeserializationTest {

    @Test
    public void deserializeTest() throws Exception {
        final String json = getJSON("api-responses/summaries.json");

        final List<Summary> summaryList = objectMapper.readValue(json, new TypeReference<List<Summary>>(){});
        assertThat(summaryList.size(), equalTo(3));

        final Summary firstSummary = summaryList.get(0);
        assertThat(firstSummary.activities.size(), equalTo(7));
        assertThat(firstSummary.activities.get(0).group, equalTo(Activity.Group.WALKING));

    }
}
