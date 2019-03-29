package com.padc.simplehabbit.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.simplehabbit.data.vos.TopicsVO;

import java.util.List;

public class TopicsResponse {

    @SerializedName("page")
    private String page;

    @SerializedName("apiVersion")
    private String apiversion;

    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    @SerializedName("topics")
    private List<TopicsVO> topics;

    public String getPage() {
        return page;
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

    public List<TopicsVO> getTopics() {
        return topics;
    }

    public boolean isSuccess(){

        return  code == 200;
    }
}
