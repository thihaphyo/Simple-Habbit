package com.padc.simplehabbit.data;

import android.content.Context;

import com.padc.simplehabbit.data.vos.CategoryProgramsVO;
import com.padc.simplehabbit.data.vos.ProgramsVO;
import com.padc.simplehabbit.delegates.CatProgResponseDelegate;
import com.padc.simplehabbit.network.DataAgent;
import com.padc.simplehabbit.network.RetrofitDA;
import com.padc.simplehabbit.persitence.SimpleHabbitDatabase;

import java.util.List;

public class CatProgsModelImpl implements CatProgsModel {

    private static CatProgsModelImpl objInstance;

    private DataAgent mDataAgent;


    private SimpleHabbitDatabase mDatabase;


    private CatProgsModelImpl(Context context) {

        mDataAgent = RetrofitDA.getObjInstance();

        mDatabase = SimpleHabbitDatabase.getObjInstance(context);
    }

    public static void initModel(Context context) {

        objInstance = new CatProgsModelImpl(context);
    }

    public static CatProgsModelImpl getObjInstance() {

        if (objInstance == null) {

            throw new RuntimeException("CatProgsModel must intialized");
        }
        return objInstance;
    }

    @Override
    public List<CategoryProgramsVO> getCatProgs(String accessToken, final CatProgsDelegate delegate) {

        if (mDatabase.isCategoryProgramsEmpty()) {


            mDataAgent.getCatProgs(accessToken, 1, new CatProgResponseDelegate() {
                @Override
                public void onSuccess(List<CategoryProgramsVO> categoryPrograms) {

                    mDatabase.catProgsDao().insert(categoryPrograms);
                    List<CategoryProgramsVO> mDBList = mDatabase.catProgsDao().getAllCategoryPrograms();
                    delegate.onSuccess(mDBList);
                }

                @Override
                public void onFail(String error) {

                    delegate.onFail(error);

                }
            });


        }

        return mDatabase.catProgsDao().getAllCategoryPrograms();


    }


    public ProgramsVO getProgramByID(String id) {

        List<CategoryProgramsVO> lsit = mDatabase.catProgsDao().getAllCategoryPrograms();

        for (CategoryProgramsVO categoryPrograms : lsit) {

            for (ProgramsVO program : categoryPrograms.getPrograms()) {

                if (program.getprogramID().equals(id)) {

                    return program;
                }
            }
        }

        return null;
    }
}
