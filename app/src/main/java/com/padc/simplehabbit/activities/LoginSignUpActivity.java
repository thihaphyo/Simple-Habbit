package com.padc.simplehabbit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.padc.simplehabbit.R;
import com.padc.simplehabbit.data.UserModel;
import com.padc.simplehabbit.data.UserModelImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginSignUpActivity extends BaseActivity {

    @BindView(R.id.btn_sign_up)
    Button btnSignUp;

    private UserModel userModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);
        ButterKnife.bind(this);

        userModel = UserModelImpl.getObjInstance();

        if (userModel.isUserLoggedIn()) {

            Intent intent = MainActivity.newIntent(getApplicationContext());
           // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }

    @OnClick(R.id.btn_sign_up)
    void onClick(View view) {

        Intent intent = RegisterActivity.newIntent(getApplicationContext());
        startActivity(intent);
    }
}

