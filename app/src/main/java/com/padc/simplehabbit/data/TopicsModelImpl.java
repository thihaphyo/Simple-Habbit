package com.padc.simplehabbit.data;

import android.content.Context;

import com.padc.simplehabbit.data.vos.TopicsVO;
import com.padc.simplehabbit.delegates.TopicResponseDelegate;
import com.padc.simplehabbit.network.DataAgent;
import com.padc.simplehabbit.network.RetrofitDA;
import com.padc.simplehabbit.persitence.SimpleHabbitDatabase;

import java.util.List;

public class TopicsModelImpl implements TopicsModel {

    private static TopicsModelImpl objInstance;

    private DataAgent mDataAgent;

    private SimpleHabbitDatabase mDatabase;

    private TopicsModelImpl(Context context) {

        mDataAgent = RetrofitDA.getObjInstance();

        mDatabase = SimpleHabbitDatabase.getObjInstance(context);

    }

    public static void initModel(Context context) {

        objInstance = new TopicsModelImpl(context);
    }

    public static TopicsModelImpl getObjInstance() {

        if (objInstance == null) {

            throw new RuntimeException("Topics Model Must intialized");

        }
        return objInstance;
    }

    @Override
    public List<TopicsVO> getTopics(String accessToken, final TopicsDeleagte deleagte) {

        if (mDatabase.isTopicsEmpty()) {

            mDataAgent.getTopics(accessToken, 1, new TopicResponseDelegate() {
                @Override
                public void onSuccess(List<TopicsVO> data) {

                    mDatabase.topicsDao().insert(data);
                    List<TopicsVO> mDBList = mDatabase.topicsDao().getAllTopics();
                    deleagte.onSuccess(mDBList);
                }

                @Override
                public void onFail(String errorMessage) {

                    deleagte.onFail(errorMessage);

                }
            });

        }

        return mDatabase.topicsDao().getAllTopics();


    }
}
