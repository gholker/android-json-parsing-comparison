package com.grahamholker.json.autovalue.gson;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoGson
@AutoValue
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

        public abstract Builder id(long id);

        public abstract Builder kind(String kind);

        public abstract Builder text(String text);

        public abstract Builder person_id(long personId);

        public abstract Builder created_at(String c); //"2013-10-16T20:58:07Z"

        public abstract Builder updated_at(String u);

        public abstract Builder story_id(long storyId);

        public abstract Builder commit_identifier(String commitId);

        public abstract Builder commit_type(String type);

        public abstract Comment build();
    }

    public static Builder builder() {
        return new AutoValue_Comment.Builder();
    }
}
