package com.padc.simplehabbit.data;

import com.padc.simplehabbit.data.vos.CategoryProgramsVO;
import com.padc.simplehabbit.data.vos.ProgramsVO;
import com.padc.simplehabbit.delegates.CatProgResponseDelegate;
import com.padc.simplehabbit.network.DataAgent;
import com.padc.simplehabbit.network.RetrofitDA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CatProgsModelImpl implements CatProgsModel {

    private static CatProgsModelImpl objInstance;

    private DataAgent mDataAgent;

    private HashMap<String, ProgramsVO> programs;


    private List<CategoryProgramsVO> mList;

    private CatProgsModelImpl() {

        programs = new HashMap<>();

        mList = new ArrayList<>();

        mDataAgent = RetrofitDA.getObjInstance();
    }

    public static CatProgsModelImpl getObjInstance() {

        if (objInstance == null) {

            objInstance = new CatProgsModelImpl();
        }
        return objInstance;
    }

    @Override
    public List<CategoryProgramsVO> getCatProgs(String accessToken, final CatProgsDelegate delegate) {

        if (mList.isEmpty()) {


            mDataAgent.getCatProgs(accessToken, 1, new CatProgResponseDelegate() {
                @Override
                public void onSuccess(List<CategoryProgramsVO> categoryPrograms) {

                    addToList(categoryPrograms);

                    delegate.onSuccess(categoryPrograms);
                }

                @Override
                public void onFail(String error) {

                    delegate.onFail(error);

                }
            });


        }

        return mList;


    }

    private void addToList(List<CategoryProgramsVO> categoryPrograms) {

        for (CategoryProgramsVO categoryProgramsVO : categoryPrograms) {

            for (ProgramsVO program : categoryProgramsVO.getPrograms()) {

                programs.put(program.getprogramID(), program);
            }

        }
    }

    public ProgramsVO getProgramByID(String id) {

        return programs.get(id);

    }
}
