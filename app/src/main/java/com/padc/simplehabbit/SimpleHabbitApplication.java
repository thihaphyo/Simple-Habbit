package com.padc.simplehabbit;

import android.app.Application;

import com.padc.simplehabbit.data.CatProgsModelImpl;
import com.padc.simplehabbit.data.TopicsModelImpl;
import com.padc.simplehabbit.data.UserModelImpl;

public class SimpleHabbitApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UserModelImpl.initUserModel(getApplicationContext());
        CatProgsModelImpl.initModel(getApplicationContext());
        TopicsModelImpl.initModel(getApplicationContext());
    }
}
