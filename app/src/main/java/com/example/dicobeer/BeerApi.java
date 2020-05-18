package com.example.dicobeer;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BeerApi {
    @GET("/v2/beers")
    Call<RestBeerResponse> getBeerResponse();
}
