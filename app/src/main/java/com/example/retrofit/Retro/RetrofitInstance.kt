package com.example.retrofit.Retro

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const  val BASE_URL="https://viacep.com.br/"
    fun getInstance():RetrofitInterface{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)



    }
}