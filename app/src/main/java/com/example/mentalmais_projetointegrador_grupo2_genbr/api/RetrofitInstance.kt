package com.example.mentalmais_projetointegrador_grupo2_genbr.api

import android.provider.SyncStateContract
import com.example.mentalmais_projetointegrador_grupo2_genbr.util.Constants.BASE_URL

object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(SyncStateContract.Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}