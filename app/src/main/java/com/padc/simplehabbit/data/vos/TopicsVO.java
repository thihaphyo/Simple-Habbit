package com.padc.simplehabbit.data.vos;

import com.google.gson.annotations.SerializedName;

public class TopicsVO {

    @SerializedName("background")
    private String background;

    @SerializedName("icon")
    private String icon;

    @SerializedName("topic-desc")
    private String topicDesc;

    @SerializedName("topic-name")
    private String topicName;

    public String getBackground() {
        return background;
    }

    public String getIcon() {
        return icon;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public String getTopicName() {
        return topicName;
    }
}
