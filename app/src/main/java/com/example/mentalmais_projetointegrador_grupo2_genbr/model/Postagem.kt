package com.example.mentalmais_projetointegrador_grupo2_genbr.model

data class Postagem (
    var id: Long,
//    var nome: String,
    var imagem: String,
    var descricao: String,
//    var data: String,
    var tema: Tema
){
}