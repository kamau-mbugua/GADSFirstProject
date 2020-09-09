package com.example.gadsproject.services;

import retrofit2.Call;
import retrofit2.http.GET;

public interface messageservice   {
    @GET("message")
    Call<String> getmessges();

}
