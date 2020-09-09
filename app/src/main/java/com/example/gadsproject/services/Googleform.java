package com.example.gadsproject.services;

import com.example.gadsproject.myinfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Googleform {

    @POST("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<myinfo> gform(
            @Field("entry.1824927963") String fmail,
            @Field("entry.1877115667") String fname,
            @Field("entry.261820127") String flname,
            @Field("entry.284483984") String flink

    );

}
