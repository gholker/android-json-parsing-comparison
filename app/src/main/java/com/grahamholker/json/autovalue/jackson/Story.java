package com.grahamholker.json.autovalue.jackson;

import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import java.util.Collections;
import java.util.List;

@AutoValue
@JsonDeserialize(builder = AutoValue_Story.Builder.class)
public abstract class Story {
    public abstract long id();

    public abstract String created_at();

    public abstract String updated_at();

    public abstract String story_type();

    public abstract String name();

    public abstract String current_state();

    @Nullable // Jackson didn't handle missing `long` as 0
    public abstract Long requested_by_id();

    public abstract String url();

    public abstract long project_id();

    public abstract List<Long> owner_ids();

    public abstract List<Label> labels();

    public abstract List<Comment> comments();

    public abstract List<Task> tasks();

    @AutoValue.Builder
    public static abstract class Builder {
        @JsonProperty("id")
        public abstract Builder id(long id);

        @JsonProperty("created_at")
        public abstract Builder created_at(String createdAt);

        @JsonProperty("updated_at")
        public abstract Builder updated_at(String updatedAt);

        @JsonProperty("story_type")
        public abstract Builder story_type(String type);

        @JsonProperty("name")
        public abstract Builder name(String name);

        @JsonProperty("current_state")
        public abstract Builder current_state(String state);

        @JsonProperty("requested_by_id")
        public abstract Builder requested_by_id(Long requestedById);

        @JsonProperty("url")
        public abstract Builder url(String url);

        @JsonProperty("project_id")
        public abstract Builder project_id(long projectId);

        @JsonProperty("owner_ids")
        public abstract Builder owner_ids(List<Long> ownerIds);

        @JsonProperty("labels")
        public abstract Builder labels(List<Label> labels);

        @JsonProperty("comments")
        public abstract Builder comments(List<Comment> comments);

        @JsonProperty("tasks")
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
