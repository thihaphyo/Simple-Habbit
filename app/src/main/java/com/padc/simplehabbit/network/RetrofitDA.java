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

        apiCall.enqueue(new SimpleHabbitCallback<CategoriesProgramsResponse, CatProgResponseDelegate>(delegate) {

            @Override
            public void onResponse(Call<CategoriesProgramsResponse> call, Response<CategoriesProgramsResponse> response) {
                super.onResponse(call, response);
                CategoriesProgramsResponse categoriesProgramsResponse = response.body();
                delegate.onSuccess(categoriesProgramsResponse.getCategoryPrograms());
            }
        });
    }

    @Override
    public void getCurrentProgram(String accessToken, int page, final CurrentProgramResponseDelegate delegate) {

        Call<CurrentProgramResponse> currentProgramCall = mApi.getCurrentProgram(accessToken, page);

        currentProgramCall.enqueue(new SimpleHabbitCallback<CurrentProgramResponse, CurrentProgramResponseDelegate>(delegate) {

            @Override
            public void onResponse(Call<CurrentProgramResponse> call, Response<CurrentProgramResponse> response) {
                super.onResponse(call, response);
                CurrentProgramResponse currentProgramResponse = response.body();
                delegate.onSuccess(currentProgramResponse.getCurrentProgramVO());
            }
        });

    }

    @Override
    public void getTopics(String accessToken, int page, final TopicResponseDelegate topicResponseDelegate) {

        Call<TopicsResponse> topicsResponseCall = mApi.getTopics(accessToken, page);
        topicsResponseCall.enqueue(new SimpleHabbitCallback<TopicsResponse, TopicResponseDelegate>(topicResponseDelegate) {

            @Override
            public void onResponse(Call<TopicsResponse> call, Response<TopicsResponse> response) {
                super.onResponse(call, response);
                TopicsResponse topicsResponse = response.body();
                topicResponseDelegate.onSuccess(topicsResponse.getTopics());

            }
        });

    }
}
