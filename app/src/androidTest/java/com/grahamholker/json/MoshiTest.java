package com.grahamholker.json;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.grahamholker.json.pojo.Story;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class MoshiTest extends BaseTest {

    private static final Type STORY_LIST_TYPE = Types.newParameterizedType(List.class, Story.class);

    @Test
    public void moshi_pojo() throws IOException {
        Moshi moshi = new Moshi.Builder()
                .build();
        final JsonAdapter<List<Story>> adapter = moshi.adapter(STORY_LIST_TYPE);
        measure("Moshi read", new Runnable() {
            @Override
            public void run() {
                try {
                    List<Story> fromMoshi = adapter.fromJson(body());
                } catch (IOException e) {
                    Log.e("gh", "Failed", e);
                }
            }
        });

        final List<Story> fromMoshi = adapter.fromJson(body());
        measure("Moshi write", new Runnable() {
            @Override
            public void run() {
                String toJson = adapter.toJson(fromMoshi);
            }
        });
    }
}
