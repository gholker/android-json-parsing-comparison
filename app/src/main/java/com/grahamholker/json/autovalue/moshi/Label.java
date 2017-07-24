package com.grahamholker.json.autovalue.moshi;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class Label {
    public abstract long id();

    public abstract long project_id();

    public abstract String kind();

    public abstract String name();

    public abstract String created_at(); //"2013-10-16T20:58:07Z"

    public abstract String updated_at();

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder id(long id);

        public abstract Builder project_id(long id);

        public abstract Builder kind(String id);

        public abstract Builder name(String id);

        public abstract Builder created_at(String id);

        public abstract Builder updated_at(String id);

        public abstract Label build();
    }

    public static Builder builder() {
        return new AutoValue_Label.Builder();
    }

    public static JsonAdapter<Label> jsonAdapter(Moshi moshi) {
        return new AutoValue_Label.MoshiJsonAdapter(moshi);
    }
}
