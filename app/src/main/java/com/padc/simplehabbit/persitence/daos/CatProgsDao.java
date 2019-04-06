package com.padc.simplehabbit.persitence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padc.simplehabbit.data.vos.CategoryProgramsVO;

import java.util.List;

@Dao
public interface CatProgsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<CategoryProgramsVO> categoryPrograms);

    @Query("SELECT * FROM category_program ORDER BY idx DESC")
    List<CategoryProgramsVO> getAllCategoryPrograms();

    @Query("SELECT * FROM category_program LIMIT 1")
    CategoryProgramsVO getTopCategoryProgram();
}
