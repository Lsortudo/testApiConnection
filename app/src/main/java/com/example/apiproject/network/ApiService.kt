package com.example.apiproject.network

import com.example.apiproject.model.ResponseApi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://proxyapp.correios.com.br/v1/sro-rastro"
private val retrofit =
    Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
interface ApiService {
    @GET("/LB524259080HK")
    fun getAllData (): Call<List<ResponseApi>>
}
object Api {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}