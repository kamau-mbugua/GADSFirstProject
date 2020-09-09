package com.example.gadsproject.services;

import android.os.Build;

import java.net.URI;
import java.net.URL;

import androidx.annotation.RequiresApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class serviceBuilder {
  private final static    String URL ="https://docs.google.com/forms/d/e/";


private static Retrofit.Builder builder=new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create());
private static Retrofit retrofit=builder.build();
 public static <S> S buildService(Class<S> serviceType){

    return  retrofit.create(serviceType);

}

}
