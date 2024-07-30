package com.example.retrofit2.Retro

class RetroInstance {

    /*fun getInstace(): RetroInterface {
        return Retrofit.Builder()
            .baseUrl("https://viacep.com.br/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetroInterface::class.java)
    }*/

    fun getNumber():Int{
        return 5
    }
}