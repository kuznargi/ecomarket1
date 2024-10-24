package com.eco.ecomarket.Interface;

import com.eco.ecomarket.Model.AirPollution.PollutionData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AirPolutionApiService {

    @GET("air_pollution?")
    Call<PollutionData> getPollution(
            @Query("lat") double lat,
            @Query("lon") double lon,

            @Query("appid") String apiKey
    );
}
