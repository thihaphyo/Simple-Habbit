package com.padc.simplehabbit.data;

import android.content.Context;

import com.padc.simplehabbit.data.vos.UserVO;
import com.padc.simplehabbit.persitence.SimpleHabbitDatabase;

public class UserModelImpl implements UserModel {


    private static UserModelImpl objInstance;

    private SimpleHabbitDatabase mDatabase;

    private UserModelImpl(Context context) {

        mDatabase = SimpleHabbitDatabase.getObjInstance(context);

    }

    public static void initUserModel(Context context) {

        objInstance = new UserModelImpl(context);
    }

    public static UserModelImpl getObjInstance() {

        if (objInstance == null) {

            throw new RuntimeException("User Model Should initialized");
        }
        return objInstance;
    }

    @Override
    public void registerUser(UserVO user, UserDelegate delegate) {

        long id = mDatabase.loginUserDao().insertUser(user);

        if (id > 0) {

            delegate.onSuccess(id);
        } else {

            delegate.onFail("SQL Error");
        }

    }

    @Override
    public void loginUser(UserVO user) {

        long id = mDatabase.loginUserDao().insertUser(user);

    }

    @Override
    public boolean isUserLoggedIn() {

        return mDatabase.isUserLoggedIn();
    }

    @Override
    public UserVO getLoginUser() {

        return mDatabase.loginUserDao().getLoginUser();
    }
}
