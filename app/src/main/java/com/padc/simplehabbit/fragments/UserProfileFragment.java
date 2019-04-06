package com.padc.simplehabbit.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.padc.simplehabbit.R;
import com.padc.simplehabbit.data.UserModel;
import com.padc.simplehabbit.data.UserModelImpl;
import com.padc.simplehabbit.data.vos.UserVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserProfileFragment extends BaseFragment {

    private UserModel mUserModel;

    private UserVO user;

    @BindView(R.id.iv_user)
    ImageView ivUser;

    @BindView(R.id.et_username)
    EditText etUserName;

    @BindView(R.id.et_email)
    EditText etEmail;

    @BindView(R.id.et_password)
    EditText etPassword;

    public UserProfileFragment() {

        mUserModel = UserModelImpl.getObjInstance();
    }

    public static UserProfileFragment newFragment() {

        return new UserProfileFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        user = mUserModel.getLoginUser();

        etUserName.setText(user.getUserName());
        etUserName.setFocusable(false);
        etEmail.setText(user.getEmail());
        etEmail.setFocusable(false);

        try {

            Glide.with(this)
                    .load(user.getImage())
                    .into(ivUser);

        } catch (Exception ex) {

            Log.e("Error", ex.getLocalizedMessage());

        }


    }
}
