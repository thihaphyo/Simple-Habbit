package com.padc.simplehabbit.data.vos;

import com.google.gson.annotations.SerializedName;

public class SessionVO {

    @SerializedName("file-path")
    private String filePath;

    @SerializedName("length-in-seconds")
    private int lengthInSeconds;

    @SerializedName("title")
    private String title;

    @SerializedName("session-id")
    private String sessionId;

    public String getFilePath() {
        return filePath;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getTitle() {
        return title;
    }

    public String getSessionId() {
        return sessionId;
    }
}
