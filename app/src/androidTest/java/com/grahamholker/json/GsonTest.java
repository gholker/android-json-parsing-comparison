package com.grahamholker.json;

import android.support.test.runner.AndroidJUnit4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.grahamholker.json.pojo.Story;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Type;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class GsonTest extends BaseTest {

    private static final Type STORY_LIST_TYPE = new TypeToken<List<Story>>() {
    }.getType();

    @Test
    public void gson_pojo() {
        final Gson gson = new GsonBuilder()
                .create();

        measure("GSON read", new Runnable() {
            @Override
            public void run() {
                List<Story> fromGson = gson.fromJson(body(), STORY_LIST_TYPE);
            }
        });

        final List<Story> fromGson = gson.fromJson(body(), STORY_LIST_TYPE);
        measure("GSON write", new Runnable() {
            @Override
            public void run() {
                String toJson = gson.toJson(fromGson);
            }
        });
    }
}
