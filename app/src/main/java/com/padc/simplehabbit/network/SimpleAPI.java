package com.padc.simplehabbit.network;

import com.padc.simplehabbit.network.responses.CategoriesProgramsResponse;
import com.padc.simplehabbit.network.responses.CurrentProgramResponse;
import com.padc.simplehabbit.network.responses.TopicsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SimpleAPI {

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<CategoriesProgramsResponse> getCatProgs(@Field("access_token") String accessToken
            , @Field("page") int page);

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<CurrentProgramResponse> getCurrentProgram(@Field("access_token") String accessToken
            , @Field("page") int page);

    @FormUrlEncoded
    @POST("getTopics.php")
    Call<TopicsResponse> getTopics(@Field("access_token") String accessToken
            , @Field("page") int page);
}
