package com.padc.simplehabbit.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "topics", indices = {@Index(value = {"idx"}, unique = true)})
public class TopicsVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idx")
    private int idx;

    @ColumnInfo(name = "background")
    @SerializedName("background")
    private String background;

    @ColumnInfo(name = "icon")
    @SerializedName("icon")
    private String icon;

    @ColumnInfo(name = "topic_desc")
    @SerializedName("topic-desc")
    private String topicDesc;

    @ColumnInfo(name = "topic_name")
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

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
