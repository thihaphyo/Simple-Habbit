package com.padc.simplehabbit.persitence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padc.simplehabbit.data.vos.TopicsVO;

import java.util.List;

@Dao
public interface TopicsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<TopicsVO> topics);

    @Query("SELECT * FROM topics")
    List<TopicsVO> getAllTopics();

    @Query("SELECT * FROM topics LIMIT 1")
    TopicsVO getLatestTopic();
}
