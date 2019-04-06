package com.padc.simplehabbit.network.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.padc.simplehabbit.data.vos.CurrentProgramVO;

public class CurrentProgramResponse  extends BaseResponse{


    @SerializedName("currentProgram")
    private CurrentProgramVO currentProgramVO;


    public CurrentProgramVO getCurrentProgramVO() {
        return currentProgramVO;
    }


}
