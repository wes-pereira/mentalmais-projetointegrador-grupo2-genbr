package com.example.mentalmais_projetointegrador_grupo2_genbr.api

import com.example.mentalmais_projetointegrador_grupo2_genbr.model.Postagem
import com.example.mentalmais_projetointegrador_grupo2_genbr.model.Tema

class Repository {
    suspend fun listTema(): Response<List<Tema>>{
        return RetrofitInstance.api.listTema()
    }

    suspend fun addPost(postagem: Postagem): Response<Postagem>{
        return RetrofitInstance.api.addPost(postagem)
    }
}