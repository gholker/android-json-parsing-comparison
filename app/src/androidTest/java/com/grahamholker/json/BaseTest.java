package com.grahamholker.json;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

import org.junit.Before;

import java.io.File;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

class BaseTest {

    private String body;

    @Before
    public void setUp() throws IOException {
        Context appContext = InstrumentationRegistry.getTargetContext();
        File cacheDir = appContext.getExternalCacheDir();
        File file = new File(cacheDir, "stories.json");
        if (file.exists()) {
            Log.d("gh", "using existing data from disk");
            BufferedSource source = Okio.buffer(Okio.source(file));
            body = source.readUtf8();
            source.close();
        } else {
            Log.d("gh", "fetching data");

            String PIVOTAL_TRACKER_API_KEY = "{INSERT YOUR KEY HERE}";
            String storiesUrl = "https://www.pivotaltracker.com" +
                    "/services/v5/projects/{PROJECT_ID}/stories" +
                    "?fields=" +
                    "id%2C" +
                    "project_id%2C" +
                    "name%2C" +
                    "current_state%2C" +
                    "story_type%2C" +
                    "url%2C" +
                    "owner_ids%2C" +
                    "labels%2C" +
                    "comments%2C" +
                    "tasks%2C" +
                    "created_at%2C" +
                    "updated_at%2C";

            OkHttpClient client = new OkHttpClient.Builder()
                    .build();
            Response response = client.newCall(new Request.Builder()
                    .header("X-TrackerToken", PIVOTAL_TRACKER_API_KEY)
                    .url(storiesUrl.replaceAll("\\{PROJECT_ID\\}", "{INSER A PROJECT ID HERE}"))
                    .build())
                    .execute();

            ResponseBody responseBody = response.body();
            if (!response.isSuccessful() || responseBody == null) {
                throw new RuntimeException("Failed to get data from Pivotal Tracker");
            }

            body = responseBody.string();
            BufferedSink sink = null;
            try {
                sink = Okio.buffer(Okio.sink(file));
                sink.writeUtf8(body);
                sink.flush();
            } catch (Exception e) {
                Log.e("gh", "Failed to write", e);
            } finally {
                if (sink != null) {
                    sink.close();
                }
            }
        }

        Log.i("gh", "Payload is " + body.getBytes().length + " bytes");
    }

    static void measure(String name, Runnable runnable) {
        measure(name, runnable, 10);
    }

    private static void measure(String name, Runnable runnable, int iterations) {
        long total = 0;
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < iterations; ++i) {
            long t1 = System.currentTimeMillis();
            runnable.run();
            long t2 = System.currentTimeMillis();
            long diff = t2 - t1;
//            Log.d("gh", name + " took: " + diff + " ms");
            total += diff;
            if (diff > max) {
                max = diff;
            }
            if (diff < min) {
                min = diff;
            }
        }

        double average = (double) total / (double) iterations;
        Log.i("gh", "name,average,max,min");
        Log.i("gh", name + "," + average + "," + max + "," + min);
    }

    String body() {
        return body;
    }

}
