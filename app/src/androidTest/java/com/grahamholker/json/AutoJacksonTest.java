package com.grahamholker.json;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grahamholker.json.autovalue.jackson.Story;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@RunWith(AndroidJUnit4.class)
public class AutoJacksonTest extends BaseTest {

    private static final TypeReference<List<Story>> LIST_AUTO_STORY_TYPEREF = new TypeReference<List<Story>>() {
    };

    @Test
    public void jackson_autovalue() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper()
                .configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

        measure("AutoJackson read", new Runnable() {
            @Override
            public void run() {
                try {
                    List<Story> fromJackson = objectMapper.readValue(body(), LIST_AUTO_STORY_TYPEREF);
                } catch (IOException e) {
                    Log.e("gh", "Failed", e);
                }
            }
        });

        final List<Story> fromJackson = objectMapper.readValue(body(), LIST_AUTO_STORY_TYPEREF);
        measure("AutoJackson write", new Runnable() {
            @Override
            public void run() {
                try {
                    String toJson = objectMapper.writeValueAsString(fromJackson);
                } catch (IOException e) {
                    Log.e("gh", "Failed", e);
                }
            }
        });

    }
}
