package com.padc.simplehabbit.data;

import com.padc.simplehabbit.data.vos.UserVO;

public interface UserModel {

    void registerUser(UserVO user,UserDelegate delegate);

    void loginUser(UserVO user);

    boolean isUserLoggedIn();

    UserVO getLoginUser();

    interface UserDelegate {

        void onSuccess(long userID);

        void onFail(String error);
    }
}
