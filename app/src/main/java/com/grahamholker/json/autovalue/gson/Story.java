package com.grahamholker.json.autovalue.gson;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.Collections;
import java.util.List;

@AutoGson
@AutoValue
public abstract class Story {
    public abstract long id();

    public abstract String created_at();

    public abstract String updated_at();

    public abstract String story_type();

    public abstract String name();

    public abstract String current_state();

    @Nullable // for jackson
    public abstract Long requested_by_id();

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

        public abstract Builder requested_by_id(Long requestedById);

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
}
