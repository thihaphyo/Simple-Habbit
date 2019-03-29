package com.padc.simplehabbit.network;

import com.padc.simplehabbit.delegates.CatProgResponseDelegate;
import com.padc.simplehabbit.delegates.CurrentProgramResponseDelegate;
import com.padc.simplehabbit.delegates.TopicResponseDelegate;

public interface DataAgent {

    void getCatProgs(String accessToken, int page, CatProgResponseDelegate delegate);

    void getCurrentProgram(String accessToken, int page, CurrentProgramResponseDelegate delegate);

    void getTopics(String accessToken, int page, TopicResponseDelegate topicResponseDelegate);
}
