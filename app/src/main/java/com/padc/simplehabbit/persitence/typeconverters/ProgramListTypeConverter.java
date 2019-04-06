package com.padc.simplehabbit.persitence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.padc.simplehabbit.data.vos.ProgramsVO;

import java.lang.reflect.Type;
import java.util.List;

public class ProgramListTypeConverter {

    @TypeConverter
    public static String fromListToJson(List<ProgramsVO> programs) {

        return new Gson().toJson(programs);
    }

    @TypeConverter
    public static List<ProgramsVO> fromJsonToList(String programs) {

        Type type = new TypeToken<List<ProgramsVO>>() {

        }.getType();

        return new Gson().fromJson(programs, type);

    }
}
