package com.padc.simplehabbit.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryProgramsVO {


    @SerializedName("title")
    private String title;


    @SerializedName("category-id")
    private String categoryID;

    @SerializedName("programs")
    private List<ProgramsVO> programs;

    public String getTitle() {
        return title;
    }

    public String getcategoryID() {
        return categoryID;
    }

    public List<ProgramsVO> getPrograms() {
        return programs;
    }
}
