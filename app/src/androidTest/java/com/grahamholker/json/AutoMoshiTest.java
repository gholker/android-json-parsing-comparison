package com.grahamholker.json;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.grahamholker.json.autovalue.moshi.MyAdapterFactory;
import com.grahamholker.json.autovalue.moshi.Story;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class AutoMoshiTest extends BaseTest {

    private static final Type STORY_LIST = Types.newParameterizedType(List.class, com.grahamholker.json.pojo.Story.class);

    @Test
    public void moshi_autovalue() throws IOException {
        Moshi moshi = new Moshi.Builder()
                .add(MyAdapterFactory.create())
                .build();
        final JsonAdapter<List<Story>> adapter = moshi.adapter(STORY_LIST);
        measure("AutoMoshi read", new Runnable() {
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
        measure("AutoMoshi write", new Runnable() {
            @Override
            public void run() {
                String toJson = adapter.toJson(fromMoshi);
            }
        });
    }
}
