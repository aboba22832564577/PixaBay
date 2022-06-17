package com.geektech.pixabay.network.retrofit;

import com.geektech.pixabay.network.model.PixaModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayApi {

    @GET("api/?key=28087804-7ca6d07127942d844d74ba2bc")
    Call<PixaModel> getImage(@Query("q") String keyWord,
                             @Query("per_page") int perPage,
                             @Query("page") int page);
    
}
