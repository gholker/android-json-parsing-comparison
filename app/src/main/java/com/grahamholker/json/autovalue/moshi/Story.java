package com.grahamholker.json.autovalue.moshi;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Collections;
import java.util.List;

@AutoValue
public abstract class Story {
    public abstract long id();

    public abstract String created_at();

    public abstract String updated_at();

    public abstract String story_type();

    public abstract String name();

    public abstract String current_state();

    public abstract long requested_by_id();

    public abstract String url();

    public abstract long project_id();

    public abstract List<Long> owner_ids();

    public abstract List<Label> labels();

    public abstract List<Comment> comments();

    public abstract List<Task> tasks();

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder id(long id);

        public abstract Builder created_at(String createdAt);

        public abstract Builder updated_at(String udpatedAt);

        public abstract Builder story_type(String type);

        public abstract Builder name(String name);

        public abstract Builder current_state(String state);

        public abstract Builder requested_by_id(long requestedById);

        public abstract Builder url(String url);

        public abstract Builder project_id(long projectId);

        public abstract Builder owner_ids(List<Long> ownerIds);

        public abstract Builder labels(List<Label> labels);

        public abstract Builder comments(List<Comment> comments);

        public abstract Builder tasks(List<Task> task);

        public abstract Story build();
    }

    public static Builder builder() {
        return new AutoValue_Story.Builder()
                .owner_ids(Collections.<Long>emptyList())
                .labels(Collections.<Label>emptyList())
                .comments(Collections.<Comment>emptyList())
                .tasks(Collections.<Task>emptyList());
    }

    public static JsonAdapter<Story> jsonAdapter(Moshi moshi) {
        return new AutoValue_Story.MoshiJsonAdapter(moshi);
    }

}
