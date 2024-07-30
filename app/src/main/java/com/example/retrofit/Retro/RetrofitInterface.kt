package com.example.retrofit.Retro

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("ws/03572010/json/")
    fun getData():Call<RetroModel>

}