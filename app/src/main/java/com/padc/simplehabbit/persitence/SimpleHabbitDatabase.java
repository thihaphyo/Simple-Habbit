package com.padc.simplehabbit.persitence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.padc.simplehabbit.data.vos.CategoryProgramsVO;
import com.padc.simplehabbit.data.vos.TopicsVO;
import com.padc.simplehabbit.data.vos.UserVO;
import com.padc.simplehabbit.persitence.daos.CatProgsDao;
import com.padc.simplehabbit.persitence.daos.LoginUserDao;
import com.padc.simplehabbit.persitence.daos.TopicsDao;
import com.padc.simplehabbit.persitence.typeconverters.ProgramListTypeConverter;

@Database(entities = {UserVO.class, CategoryProgramsVO.class, TopicsVO.class}, version = 2)
@TypeConverters({
        ProgramListTypeConverter.class
})
public abstract class SimpleHabbitDatabase extends RoomDatabase {

    private static SimpleHabbitDatabase objInstance;

    public abstract LoginUserDao loginUserDao();

    public abstract CatProgsDao catProgsDao();

    public abstract TopicsDao topicsDao();

    public static SimpleHabbitDatabase getObjInstance(Context context) {

        if (objInstance == null) {

            objInstance = Room.databaseBuilder(context
                    , SimpleHabbitDatabase.class, "sdb")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return objInstance;
    }

    public boolean isUserLoggedIn() {

        return objInstance.loginUserDao().getLoginUser() != null;
    }


    public boolean isCategoryProgramsEmpty() {

        return objInstance.catProgsDao().getTopCategoryProgram() == null;
    }

    public boolean isTopicsEmpty() {

        return objInstance.topicsDao().getLatestTopic() == null;
    }

}
