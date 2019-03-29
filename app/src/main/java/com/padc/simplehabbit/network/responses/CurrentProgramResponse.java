package com.padc.simplehabbit.network.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.padc.simplehabbit.data.vos.CurrentProgramVO;

public class CurrentProgramResponse {

    @SerializedName("apiVersion")
    private String apiversion;

    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    @SerializedName("currentProgram")
    private CurrentProgramVO currentProgramVO;

    public String getApiversion() {
        return apiversion;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public CurrentProgramVO getCurrentProgramVO() {
        return currentProgramVO;
    }

    public boolean isSuccess() {

        return code == 200;
    }
}
