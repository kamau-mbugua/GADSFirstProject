package com.example.gadsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class first extends AppCompatActivity {
    private static final String url="https://gadsapi.herokuapp.com/api/skilliq";
private RecyclerView recyclerView;
private RecyclerView.Adapter adapter;
private List<Listitem> listitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        recyclerView=findViewById(R.id.recleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listitems=new ArrayList<>();
       loadrecycleview();

    }
    private  void loadrecycleview(){

        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading Data");
        progressDialog.show();
        StringRequest stringRequest= new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {

                            JSONArray array= new JSONArray(response);
                            for(int i=0;i<array.length(); i++){

                                JSONObject o=array.getJSONObject(i);
                                Listitem item =new Listitem(o.getString("name"),
                                        o.getString("score"),
                                        o.getString("country"),
                                        o.getString("badgeUrl"));
                                listitems.add(item);
                            }
                            adapter =new Myadapter(listitems,getApplicationContext());
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public static void mdi(){



    }
}
