package com.dsm.retrofitappmockapi.clases.service

import com.dsm.retrofitappmockapi.clases.body.RecursosResponse
import com.dsm.retrofitappmockapi.clases.ejemplo
import retrofit2.Call
import retrofit2.http.GET

interface RecursosApiService {
    @GET("resources")
    fun callResources(): Call<List<RecursosResponse>>

    @GET("ejemplo")
    fun callEjemplos(): Call<List<ejemplo>>
}