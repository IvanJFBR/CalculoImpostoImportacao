package com.ivstech.impostoimportacao.APIController

import retrofit2.Call
import retrofit2.http.GET

interface RegiaoService {
    @GET("api/v1/localidades/estados")
    fun list() : Call<List<Regiao>>
}