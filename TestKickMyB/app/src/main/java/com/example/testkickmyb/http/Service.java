package com.example.testkickmyb.http;

import org.kickmyb.transfer.HomeItemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("test")
    Call<String> test();

    @GET("/api/home")
    Call<List<HomeItemResponse>> home();
}
