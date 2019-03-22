package com.example.dp.API;

import com.example.dp.Model.HouseList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService
{
    @GET("estate/search?key=6d35e1f591aa413189aa34cd93dc26fb")
    Call<HouseList> getUsers();
}
