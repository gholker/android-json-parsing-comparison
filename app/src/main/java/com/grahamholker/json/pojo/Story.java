package com.grahamholker.json.pojo;

import java.util.List;

public class Story {
    public long id;
    public String kind;
    public String created_at;
    public String updated_at;
    public String story_type;
    public String name;
    public String current_state;
    public long requested_by_id;
    public String url;
    public long project_id;
    public List<Long> owner_ids;
    public List<Label> labels;
    public List<Comment> comments;
    public List<Task> tasks;
}
