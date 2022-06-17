package com.geektech.pixabay.network.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static PixabayApi pixabayApi;

    private RetrofitService() {
    }


    public static PixabayApi getPixabayApi() {
        if (pixabayApi == null) {
            pixabayApi = getApi();
        }
        return pixabayApi;
    }

    private static PixabayApi getApi() {
        return new Retrofit.Builder()
                .baseUrl("https://pixabay.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(PixabayApi.class);
    }


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pixabay.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
