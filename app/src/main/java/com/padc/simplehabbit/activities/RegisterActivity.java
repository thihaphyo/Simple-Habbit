package com.padc.simplehabbit.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.padc.simplehabbit.R;
import com.padc.simplehabbit.data.UserModel;
import com.padc.simplehabbit.data.UserModelImpl;
import com.padc.simplehabbit.data.vos.UserVO;

import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.et_username)
    EditText etUserName;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.iv_user)
    ImageView ivUserProfile;
    @BindView(R.id.btnRegister)
    Button btnRegister;
    @BindView(R.id.uploadImage)
    ImageView btnUpload;

    public static final int PICK_IMAGE = 1;
    private byte[] userProfile;
    private UserModel mUserModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        mUserModel = UserModelImpl.getObjInstance();
    }

    public static Intent newIntent(Context context) {

        Intent intent = new Intent(context, RegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return new Intent(context, RegisterActivity.class);
    }


    @OnClick(R.id.btnRegister)
    void onClickRegister(View view) {

        String username = etUserName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etEmail.getText().toString();

        UserVO user = new UserVO();
        user.setUserName(username);
        user.setEmail(email);
        user.setPassword(password);
        if (userProfile == null || userProfile.length == 0) {

            return;
        }
        user.setImage(userProfile);

        mUserModel.registerUser(user, new UserModel.UserDelegate() {
            @Override
            public void onSuccess(long userID) {
                Log.e("User ID", userID + "");

                Intent intent = MainActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }

            @Override
            public void onFail(String error) {

                Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();

            }
        });

    }

    @OnClick(R.id.uploadImage)
    void onClickUpload(View view) {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == PICK_IMAGE) {

            if (data != null) {

                try {
                    InputStream inputStream = getApplicationContext()
                            .getContentResolver().openInputStream(data.getData());

                    ivUserProfile.setImageURI(data.getData());
                    userProfile = IOUtils.toByteArray(inputStream);


                } catch (FileNotFoundException e) {

                    e.printStackTrace();
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }

            } else {
                return;
            }
        }
    }
}
