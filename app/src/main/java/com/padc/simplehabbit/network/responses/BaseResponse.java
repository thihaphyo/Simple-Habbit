package com.padc.simplehabbit.network.responses;

import com.google.gson.annotations.SerializedName;

public abstract class BaseResponse {

    @SerializedName("apiVersion")
    private String apiversion;

    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    public boolean isSuccess() {

        return true;
    }

    public String getApiversion() {
        return apiversion;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
