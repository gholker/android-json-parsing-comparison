package com.grahamholker.json;

import android.support.test.runner.AndroidJUnit4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.grahamholker.json.autovalue.gson.AutoValueAdapterFactory;
import com.grahamholker.json.autovalue.gson.Story;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Type;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class AutoGsonTest extends BaseTest {

    private static final Type STORY_LIST_TYPE = new TypeToken<List<Story>>() {
    }.getType();

    @Test
    public void gson_autovalue() {
        final Gson autoGson = new GsonBuilder()
                .registerTypeAdapterFactory(new AutoValueAdapterFactory())
                .create();

        measure("AutoGson read", new Runnable() {
            @Override
            public void run() {
                List<Story> fromGson = autoGson.fromJson(body(), STORY_LIST_TYPE);
            }
        });

        final List<Story> fromAutoGson = autoGson.fromJson(body(), STORY_LIST_TYPE);
        measure("AutoGson write", new Runnable() {
            @Override
            public void run() {
                String toJson = autoGson.toJson(fromAutoGson);
            }
        });

    }
}
