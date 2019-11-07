package com.ivstech.impostoimportacao.APIController

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://servicodados.ibge.gov.br/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun regiaoService () = retrofit.create(RegiaoService::class.java)
}