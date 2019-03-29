package com.padc.simplehabbit.data;

import com.padc.simplehabbit.data.vos.CurrentProgramVO;

public interface CurrentProgramModel {

    CurrentProgramVO getCurrentProgram(String accessToken, CurrentProgramDelegate delegate);

    interface CurrentProgramDelegate {

        void onSuccess(CurrentProgramVO currentProgram);

        void onFail(String errorMessge);
    }
}
