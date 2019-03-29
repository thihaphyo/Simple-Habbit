package com.padc.simplehabbit.network;

import com.google.gson.Gson;
import com.padc.simplehabbit.delegates.CatProgResponseDelegate;
import com.padc.simplehabbit.delegates.CurrentProgramResponseDelegate;
import com.padc.simplehabbit.delegates.TopicResponseDelegate;
import com.padc.simplehabbit.network.responses.CategoriesProgramsResponse;
import com.padc.simplehabbit.network.responses.CurrentProgramResponse;
import com.padc.simplehabbit.network.responses.TopicsResponse;
import com.padc.simplehabbit.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDA implements DataAgent {

    private static RetrofitDA objInstance;

    private SimpleAPI mApi;

    private RetrofitDA() {


        final OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mApi = retrofit.create(SimpleAPI.class);


    }

    public static RetrofitDA getObjInstance() {

        if (objInstance == null) {

            objInstance = new RetrofitDA();
        }
        return objInstance;
    }

    @Override
    public void getCatProgs(String accessToken, int page, final CatProgResponseDelegate delegate) {


        Call<CategoriesProgramsResponse> apiCall = mApi.getCatProgs(accessToken, page);

        apiCall.enqueue(new Callback<CategoriesProgramsResponse>() {
            @Override
            public void onResponse(Call<CategoriesProgramsResponse> call, Response<CategoriesProgramsResponse> response) {

                CategoriesProgramsResponse categoriesProgramsResponse = response.body();

                if (categoriesProgramsResponse.isSuccess()) {

                    delegate.onSuccess(categoriesProgramsResponse.getCategoryPrograms());

                } else {

                    delegate.onFail(categoriesProgramsResponse.getMessage());

                }
            }

            @Override
            public void onFailure(Call<CategoriesProgramsResponse> call, Throwable t) {

                delegate.onFail(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void getCurrentProgram(String accessToken, int page, final CurrentProgramResponseDelegate delegate) {


        Call<CurrentProgramResponse> currentProgramCall = mApi.getCurrentProgram(accessToken, page);

        currentProgramCall.enqueue(new Callback<CurrentProgramResponse>() {

            @Override
            public void onResponse(Call<CurrentProgramResponse> call, Response<CurrentProgramResponse> response) {

                CurrentProgramResponse currentProgramResponse = response.body();
                if (currentProgramResponse.isSuccess()) {

                    delegate.onSuccess(currentProgramResponse.getCurrentProgramVO());

                } else {

                    delegate.onFail(currentProgramResponse.getMessage());

                }


            }

            @Override
            public void onFailure(Call<CurrentProgramResponse> call, Throwable t) {

                delegate.onFail(t.getMessage());

            }
        });

    }

    @Override
    public void getTopics(String accessToken, int page, final TopicResponseDelegate topicResponseDelegate) {


        Call<TopicsResponse> topicsResponseCall = mApi.getTopics(accessToken, page);
        topicsResponseCall.enqueue(new Callback<TopicsResponse>() {
            @Override
            public void onResponse(Call<TopicsResponse> call, Response<TopicsResponse> response) {

                TopicsResponse topicsResponse = response.body();

                if (topicsResponse.isSuccess()) {

                    topicResponseDelegate.onSuccess(topicsResponse.getTopics());

                } else {

                    topicResponseDelegate.onFail(topicsResponse.getMessage());
                }

            }

            @Override
            public void onFailure(Call<TopicsResponse> call, Throwable t) {

                topicResponseDelegate.onFail(t.getMessage());

            }
        });

    }
}
