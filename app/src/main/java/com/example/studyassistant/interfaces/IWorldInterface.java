package com.example.studyassistant.interfaces;

import com.example.studyassistant.utils.APIManager;

import retrofit2.Call;
import retrofit2.http.GET;


public interface IWorldInterface {

    @GET(APIManager.WORLD_URL)
    Call<String> getList();

    @GET(APIManager.QUANWU_URL)
    Call<String> getQuan();

    @GET(APIManager.GOOD_HEJI)
    Call<String> getHeJi();

    @GET(APIManager.GOOD_FENLEI)
    Call<String> getFenLei();
}
