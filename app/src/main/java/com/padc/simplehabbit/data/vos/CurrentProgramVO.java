package com.padc.simplehabbit.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentProgramVO {

    @SerializedName("description")
    private String description;

    @SerializedName("average-lengths")
    private List<Integer> averageLength;

    @SerializedName("background")
    private String image;

    @SerializedName("title")
    private String title;

    @SerializedName("program-id")
    private String programID;

    @SerializedName("current-period")
    private String currentPeriod;

    @SerializedName("sessions")
    private List<SessionVO> session;

    public String getDescription() {
        return description;
    }

    public List<Integer> getaverageLength() {
        return averageLength;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getprogramID() {
        return programID;
    }

    public List<SessionVO> getSession() {
        return session;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }
}
