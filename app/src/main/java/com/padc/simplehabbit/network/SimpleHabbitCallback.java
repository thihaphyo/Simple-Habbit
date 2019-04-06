package com.padc.simplehabbit.network;

import com.padc.simplehabbit.delegates.BaseResponseDelegate;
import com.padc.simplehabbit.network.responses.BaseResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class SimpleHabbitCallback<T extends BaseResponse, W extends BaseResponseDelegate> implements Callback<T> {

    private W networkDelegate;
    SimpleHabbitCallback(W networkDelegate) {

        this.networkDelegate = networkDelegate;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        T dataRespnse = response.body();

        if (dataRespnse == null) {

            networkDelegate.onFail("NULL");
            return;

        } else {

            if (!dataRespnse.isSuccess()) {

                networkDelegate.onFail(dataRespnse.getMessage());
                return;
            }

        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

        networkDelegate.onFail(t.getLocalizedMessage());
        return;

    }
}
