package com.example.mentalmais_projetointegrador_grupo2_genbr.model

data class Tema(
    var id: Long,
    var nome: String?,
    var postagens: List<Postagem>?
) {

    override fun toString(): String {
        return nome!!
    }

}
