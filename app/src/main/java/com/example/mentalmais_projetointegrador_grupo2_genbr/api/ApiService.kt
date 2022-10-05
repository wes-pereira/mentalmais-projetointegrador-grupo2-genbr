package com.example.mentalmais_projetointegrador_grupo2_genbr.api

import com.example.mentalmais_projetointegrador_grupo2_genbr.model.Postagem
import com.example.mentalmais_projetointegrador_grupo2_genbr.model.Tema
import com.junior.testepi.model.Postagem
import com.junior.testepi.model.Tema
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("tema")
    suspend fun listTema():Response<List<Tema>>

    @POST("postagem")
    suspend fun addPost(
        @Body postagem: Postagem
    ): Response<Postagem>
}