package com.padc.simplehabbit.persitence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padc.simplehabbit.data.vos.UserVO;

@Dao
public interface LoginUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertUser(UserVO user);

    @Query("DELETE FROM user")
    void deleteUser();

    @Query("SELECT * FROM user LIMIT 1")
    UserVO getLoginUser();
}
