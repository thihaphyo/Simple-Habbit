package com.padc.simplehabbit.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.simplehabbit.data.vos.TopicsVO;

import java.util.List;

public class TopicsResponse extends BaseResponse {

    @SerializedName("page")
    private String page;

    @SerializedName("topics")
    private List<TopicsVO> topics;

    public String getPage() {
        return page;
    }

    public List<TopicsVO> getTopics() {
        return topics;
    }


}
