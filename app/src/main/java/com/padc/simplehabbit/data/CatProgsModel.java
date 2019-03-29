package com.padc.simplehabbit.data;

import com.padc.simplehabbit.data.vos.CategoryProgramsVO;

import java.util.List;

public interface CatProgsModel {

    List<CategoryProgramsVO> getCatProgs(String accessToken, CatProgsDelegate delegate);

    interface CatProgsDelegate {

        void onSuccess(List<CategoryProgramsVO> categoryProgramsVOS);

        void onFail(String error);
    }
}
