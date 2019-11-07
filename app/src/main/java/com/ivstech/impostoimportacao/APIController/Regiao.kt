package com.ivstech.impostoimportacao.APIController

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Regiao (id: Int, nome: String, sigla: String) {
    @SerializedName("id")
    @Expose
    private  val _id: Int = id

    @SerializedName("nome")
    @Expose
    private  val _nome: String = nome

    @SerializedName("sigla")
    @Expose
    private  val _sigla: String = sigla

    val id: Int
        get() {return _id}
    val nome: String
        get() {return _nome}
    val sigla: String
        get() {return _sigla}
}