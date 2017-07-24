package com.grahamholker.json.autovalue.jackson;

import android.support.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

@AutoValue
@JsonDeserialize(builder = AutoValue_Comment.Builder.class)
public abstract class Comment {
    public abstract String kind();

    public abstract long id();

    @Nullable
    public abstract String text();

    public abstract long person_id();

    public abstract String created_at(); //"2013-10-16T20:58:07Z"

    public abstract String updated_at();

    public abstract long story_id();

    @Nullable
    public abstract String commit_identifier();

    @Nullable
    public abstract String commit_type();

    @AutoValue.Builder
    public static abstract class Builder {

        @JsonProperty("id")
        public abstract Builder id(long id);

        @JsonProperty("kind")
        public abstract Builder kind(String kind);

        @JsonProperty("text")
        public abstract Builder text(String text);

        @JsonProperty("person_id")
        public abstract Builder person_id(long personId);

        @JsonProperty("created_at")
        public abstract Builder created_at(String c); //"2013-10-16T20:58:07Z"

        @JsonProperty("updated_at")
        public abstract Builder updated_at(String u);

        @JsonProperty("story_id")
        public abstract Builder story_id(long storyId);

        @JsonProperty("commit_identifier")
        public abstract Builder commit_identifier(String commitId);

        @JsonProperty("commit_type")
        public abstract Builder commit_type(String type);

        public abstract Comment build();
    }

    public static Builder builder() {
        return new AutoValue_Comment.Builder();
    }
}
