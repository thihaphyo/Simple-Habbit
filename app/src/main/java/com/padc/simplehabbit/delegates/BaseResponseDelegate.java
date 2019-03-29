package com.padc.simplehabbit.delegates;

public interface BaseResponseDelegate<T> {

    void onSuccess(T data);

    void onFail(String errorMessage);
}
