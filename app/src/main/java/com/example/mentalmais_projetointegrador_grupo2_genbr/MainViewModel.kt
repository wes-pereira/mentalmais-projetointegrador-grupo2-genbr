package com.example.mentalmais_projetointegrador_grupo2_genbr

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mentalmais_projetointegrador_grupo2_genbr.api.Repository
import com.example.mentalmais_projetointegrador_grupo2_genbr.model.Postagem
import com.example.mentalmais_projetointegrador_grupo2_genbr.model.Tema
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository)
    : ViewModel() {

    private val _myTemaResponse = MutableLiveData<Response<List<Tema>>>()

    val myTemaResponse: LiveData<Response<List<Tema>>> = _myTemaResponse

//
//    init {
//        listTema()
//    }

    fun listTema(){
        viewModelScope.launch {

            try {
                val response = repository.listTema()
                _myTemaResponse.value = response
            }catch (e: Exception){
                Log.d("Erro:/", e.message.toString())
            }

        }
    }
    fun addPost(postagem: Postagem){
        viewModelScope.launch {
            try {
                val response = repository.addPost(postagem)
                Log.d("jsaid", "jodasjod")

            }catch (e: Exception){
                Log.d("Erro:/", e.message.toString())
            }
        }
    }
}