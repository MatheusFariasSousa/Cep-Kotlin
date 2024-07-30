package com.example.retrofit2.Retro

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetroInterface {
    @GET("ws/{cep}/json")
    fun getData(@Path("cep")cep:String):Call<RetroModel>
}