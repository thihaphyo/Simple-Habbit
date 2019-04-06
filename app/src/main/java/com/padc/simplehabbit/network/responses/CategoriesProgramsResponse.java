package com.padc.simplehabbit.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.simplehabbit.data.vos.CategoryProgramsVO;

import java.util.List;

public class CategoriesProgramsResponse extends BaseResponse {

    @SerializedName("page")
    private String page;

    @SerializedName("categoriesPrograms")
    private List<CategoryProgramsVO> categoryPrograms;

    public String getPage() {
        return page;
    }


    public List<CategoryProgramsVO> getCategoryPrograms() {
        return categoryPrograms;
    }

}
