package com.grahamholker.json.autovalue.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

@AutoValue
@JsonDeserialize(builder = AutoValue_Task.Builder.class)
public abstract class Task {
    @JsonProperty("id")
    public abstract long id();

    @JsonProperty("kind")
    public abstract String kind();

    @JsonProperty("description")
    public abstract String description();

    @JsonProperty("complete")
    public abstract boolean complete();

    @JsonProperty("story_id")
    public abstract long story_id();

    @JsonProperty("position")
    public abstract int position();

    @JsonProperty("created_at")
    public abstract String created_at();

    @JsonProperty("updated_at")
    public abstract String updated_at();

    @AutoValue.Builder
    public static abstract class Builder {
        @JsonProperty("id")
        public abstract Builder id(long id);

        @JsonProperty("kind")
        public abstract Builder kind(String id);

        @JsonProperty("description")
        public abstract Builder description(String id);

        @JsonProperty("complete")
        public abstract Builder complete(boolean complete);

        @JsonProperty("story_id")
        public abstract Builder story_id(long story_id);

        @JsonProperty("position")
        public abstract Builder position(int position);

        @JsonProperty("created_at")
        public abstract Builder created_at(String created_at);

        @JsonProperty("updated_at")
        public abstract Builder updated_at(String updated_at);

        public abstract Task build();
    }

    public static Builder builder() {
        return new AutoValue_Task.Builder();
    }
}

