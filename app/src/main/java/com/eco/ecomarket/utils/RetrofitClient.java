package com.eco.ecomarket.utils;

import com.eco.ecomarket.Adapter.AirPolution;
import com.eco.ecomarket.Interface.AirPolutionApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String Base = "https://api.openweathermap.org/data/2.5/";

    private static AirPolutionApiService api;

    public static AirPolutionApiService getApi() {
        if (api == null) {
            api = new Retrofit.Builder()
                    .baseUrl(Base)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(AirPolutionApiService.class);
        }
        return api;
    }
}
