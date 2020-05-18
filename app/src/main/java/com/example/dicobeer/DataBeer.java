package com.example.dicobeer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataBeer extends AppCompatActivity {

    private static final String BASE_URL = "https://api.punkapi.com/";
    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_beer);

        showList();
        makeApiCall();
    }

    private void showList() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<String> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }// define an adapter

        mAdapter = new ListAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }

    private void makeApiCall() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        BeerApi beerApi = retrofit.create(BeerApi.class);

        Call<RestBeerResponse> call = beerApi.getBeerResponse();
        call.enqueue(new Callback<RestBeerResponse>() {
            @Override
            public void onResponse(Call<RestBeerResponse> call, Response<RestBeerResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    List<Beer> ListBeer = response.body().getNumber();
                    Toast.makeText(getApplicationContext(),"Api Success", Toast.LENGTH_LONG).show();
                }else{
                    showError();
                }
            }

            @Override
            public void onFailure(Call<RestBeerResponse> call, Throwable t) {
                showError();

            }
        });
    }
    private void showError() {
        Toast.makeText(getApplicationContext(), "Api Error", Toast.LENGTH_LONG).show();
    }
}
