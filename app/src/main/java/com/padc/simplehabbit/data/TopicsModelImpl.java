package com.padc.simplehabbit.data;

import com.padc.simplehabbit.data.vos.TopicsVO;
import com.padc.simplehabbit.delegates.TopicResponseDelegate;
import com.padc.simplehabbit.network.DataAgent;
import com.padc.simplehabbit.network.RetrofitDA;

import java.util.ArrayList;
import java.util.List;

public class TopicsModelImpl implements TopicsModel {

    private static TopicsModelImpl objInstance;

    private DataAgent mDataAgent;

    private List<TopicsVO> mTopics;

    private TopicsModelImpl() {

        mTopics = new ArrayList<>();

        mDataAgent = RetrofitDA.getObjInstance();

    }

    public static TopicsModelImpl getObjInstance() {

        if (objInstance == null) {

            objInstance = new TopicsModelImpl();

        }
        return objInstance;
    }

    @Override
    public List<TopicsVO> getTopics(String accessToken, final TopicsDeleagte deleagte) {

        if (mTopics.isEmpty()) {

            mDataAgent.getTopics(accessToken, 1, new TopicResponseDelegate() {
                @Override
                public void onSuccess(List<TopicsVO> data) {

                    mTopics = data;

                    deleagte.onSuccess(data);
                }

                @Override
                public void onFail(String errorMessage) {

                    deleagte.onFail(errorMessage);

                }
            });

        }

        return mTopics;


    }
}
