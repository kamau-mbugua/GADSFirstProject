package com.example.gadsproject;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gadsproject.services.Googleform;
import com.example.gadsproject.services.messageservice;
import com.example.gadsproject.services.serviceBuilder;


public class submit extends AppCompatActivity {
TextView name,lname,email,link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .build();


        final Googleform googleform= serviceBuilder.buildService(Googleform.class);


        email = (TextView) findViewById(R.id.email);
        name =  findViewById(R.id.fname);
        lname = (TextView) findViewById(R.id.lname);
        link = (TextView) findViewById(R.id.link);

    }



    public void submit() {
        String fname = name.getText().toString();
        String fmail = email.getText().toString();
        String flname = lname.getText().toString();
        String flink = link.getText().toString();

        final Googleform googleform= serviceBuilder.buildService(Googleform.class);
        final Call<myinfo> complete = googleform.gform(fname, fmail, flname, flink);
            complete.enqueue(Callback);
    }

    private final Callback<myinfo> Callback = new Callback<myinfo>() {
        @Override
        public void onResponse(Call<myinfo> call, Response<myinfo> response) {
successdialog();
        }

        @Override
        public void onFailure(Call<myinfo> call, Throwable throwable) {
faildialog();
        }


    };

    public void submits(View view) {
        String fname = name.getText().toString();
        String fmail = email.getText().toString();
        String flname = lname.getText().toString();
        String flink = link.getText().toString();
        if (fname.equals("") || fmail.equals("") || flink.equals("") || flname.equals("")) {

            Toast.makeText(this, "Empty failed is not allowed", Toast.LENGTH_SHORT).show();
        }
        else{
      showdialog();}
    }

    public void showmessage(String title, String message){

        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);

        builder.setMessage(message);

        builder.show();
    }
    public void showdialog(){

        Dialog dialog=new Dialog(submit.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
       // dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
        dialog.setContentView(R.layout.confirm_dialog);
        Button dialog_btn=dialog.findViewById(R.id.confirm);
        ImageView image=dialog.findViewById(R.id.image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                submit();
            }
        });
        dialog.show();
    }

    public void faildialog(){

        Dialog dialog=new Dialog(submit.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
        dialog.setContentView(R.layout.fail_dialog);
        dialog.show();
    }


    public void successdialog(){

        Dialog dialog=new Dialog(submit.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
        dialog.setContentView(R.layout.success_dialog);
        dialog.show();
    }
}
