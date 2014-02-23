package me.pims.moves.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.net.URL;

public abstract class BaseDeserializationTest {

    public final ObjectMapper objectMapper = new ObjectMapper();


    public String getJSON(final String filePath) throws Exception {
        URL url = Resources.getResource(filePath);
        return Resources.toString(url, Charsets.UTF_8);
    }

    public abstract void deserializeTest() throws Exception;
}
