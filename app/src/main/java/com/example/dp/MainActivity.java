package com.example.dp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dp.API.APIService;
import com.example.dp.API.APIUrl;
import com.example.dp.Controller.HouseAdapter;
import com.example.dp.Model.HouseList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private HouseAdapter adapter;
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=(RecyclerView)findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        Retrofit retrofit=new Retrofit.Builder().baseUrl(APIUrl.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        APIService service=retrofit.create(APIService.class);
        Call<HouseList> call=service.getUsers();
        call.enqueue(new Callback<HouseList>() {
            @Override
            public void onResponse(Call<HouseList> call, Response<HouseList> response) {
                adapter=new HouseAdapter(response.body().getHouses(),getApplicationContext());
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<HouseList> call, Throwable t) {

            }
        });
    }
}
