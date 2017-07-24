package com.grahamholker.json.autovalue.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

@AutoValue
@JsonDeserialize(builder = AutoValue_Label.Builder.class)
public abstract class Label {
    @JsonProperty("id")
    public abstract long id();

    @JsonProperty("project_id")
    public abstract long project_id();

    @JsonProperty("kind")
    public abstract String kind();

    @JsonProperty("name")
    public abstract String name();

    @JsonProperty("created_at")
    public abstract String created_at(); //"2013-10-16T20:58:07Z"

    @JsonProperty("updated_at")
    public abstract String updated_at();

    @AutoValue.Builder
    public static abstract class Builder {

        @JsonProperty("id")
        public abstract Builder id(long id);

        @JsonProperty("project_id")
        public abstract Builder project_id(long id);

        @JsonProperty("kind")
        public abstract Builder kind(String id);

        @JsonProperty("name")
        public abstract Builder name(String id);

        @JsonProperty("created_at")
        public abstract Builder created_at(String id);

        @JsonProperty("updated_at")
        public abstract Builder updated_at(String id);

        public abstract Label build();
    }

    public static Builder builder() {
        return new AutoValue_Label.Builder();
    }
}
