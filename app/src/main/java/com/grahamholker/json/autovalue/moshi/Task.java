package com.grahamholker.json.autovalue.moshi;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class Task {
    public abstract long id();

    public abstract String kind();

    public abstract String description();

    public abstract boolean complete();

    public abstract long story_id();

    public abstract int position();

    public abstract String created_at();

    public abstract String updated_at();

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder id(long id);

        public abstract Builder kind(String id);

        public abstract Builder description(String id);

        public abstract Builder complete(boolean complete);

        public abstract Builder story_id(long story_id);

        public abstract Builder position(int position);

        public abstract Builder created_at(String created_at);

        public abstract Builder updated_at(String updated_at);

        public abstract Task build();
    }

    public static Builder builder() {
        return new AutoValue_Task.Builder();
    }

    public static JsonAdapter<Task> jsonAdapter(Moshi moshi) {
        return new AutoValue_Task.MoshiJsonAdapter(moshi);
    }
}

