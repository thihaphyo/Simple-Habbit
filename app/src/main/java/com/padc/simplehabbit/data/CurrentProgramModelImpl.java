package com.padc.simplehabbit.data;

import com.padc.simplehabbit.data.vos.CurrentProgramVO;
import com.padc.simplehabbit.delegates.CurrentProgramResponseDelegate;
import com.padc.simplehabbit.network.DataAgent;
import com.padc.simplehabbit.network.RetrofitDA;

public class CurrentProgramModelImpl implements CurrentProgramModel {

    private static CurrentProgramModelImpl objInstance;

    private DataAgent dataAgent;

    private CurrentProgramVO currentProgram;

    private CurrentProgramModelImpl() {

        dataAgent = RetrofitDA.getObjInstance();
    }

    public static CurrentProgramModelImpl getObjInstance() {

        if (objInstance == null) {

            objInstance = new CurrentProgramModelImpl();
        }
        return objInstance;
    }

    @Override
    public CurrentProgramVO getCurrentProgram(String accessToken, final CurrentProgramDelegate delegate) {

        if (currentProgram == null) {

            dataAgent.getCurrentProgram(accessToken, 1, new CurrentProgramResponseDelegate() {
                @Override
                public void onSuccess(CurrentProgramVO data) {

                    currentProgram = data;

                    delegate.onSuccess(data);
                }

                @Override
                public void onFail(String errorMessage) {

                    delegate.onFail(errorMessage);

                }
            });

        }

        return currentProgram;

    }
}
