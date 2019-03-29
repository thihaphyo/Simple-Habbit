package com.padc.simplehabbit.network.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.padc.simplehabbit.data.vos.CategoryProgramsVO;

import java.util.List;

public class CategoriesProgramsResponse {

    @SerializedName("page")
    private String page;

    @SerializedName("apiVersion")
    private String apiversion;

    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    @SerializedName("categoriesPrograms")
    private List<CategoryProgramsVO> categoryPrograms;

    public String getPage() {
        return page;
    }

    public String getApiversion() {
        return apiversion;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public List<CategoryProgramsVO> getCategoryPrograms() {
        return categoryPrograms;
    }

    public boolean isSuccess() {

        return code == 200;
    }
}
