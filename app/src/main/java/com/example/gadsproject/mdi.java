package com.example.gadsproject;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gadsproject.services.messageservice;
import com.example.gadsproject.services.serviceBuilder;

import java.io.IOException;

public class mdi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdi);
        messageservice taskservice= serviceBuilder.buildService(messageservice.class);

retrofit2.Call<String> cal1=taskservice.getmessges();
cal1.enqueue(new retrofit2.Callback<String>() {
    @Override
    public void onResponse(retrofit2.Call<String> call, retrofit2.Response<String> response) {
        ((TextView) findViewById(R.id.message)).setText(response.body());
    }

    @Override
    public void onFailure(retrofit2.Call<String> call, Throwable throwable) {
        ((TextView) findViewById(R.id.message)).setText(("failed"));
    }
});










    }
}
