package com.padc.simplehabbit.data;

import com.padc.simplehabbit.data.vos.TopicsVO;

import java.util.List;

public interface TopicsModel {

    List<TopicsVO> getTopics(String accessToken, TopicsDeleagte deleagte);

    interface TopicsDeleagte {

        void onSuccess(List<TopicsVO> topics);

        void onFail(String error);
    }
}
