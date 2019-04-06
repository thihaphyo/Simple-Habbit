package com.padc.simplehabbit.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

@Entity(tableName = "user")
public class UserVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    private int userID;

    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "password")
    private String password;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB, name = "image")
    private byte[] image;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


}
