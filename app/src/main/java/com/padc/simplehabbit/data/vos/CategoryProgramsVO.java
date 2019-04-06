package com.padc.simplehabbit.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "category_program", indices = {@Index(value = {"cat_id"}, unique = true)})
public class CategoryProgramsVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idx")
    private int idx;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;

    @ColumnInfo(name = "cat_id")
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

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public void setPrograms(List<ProgramsVO> programs) {
        this.programs = programs;
    }
}
