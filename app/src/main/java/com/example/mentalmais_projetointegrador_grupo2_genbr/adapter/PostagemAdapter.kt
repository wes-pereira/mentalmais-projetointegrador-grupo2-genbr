package com.example.mentalmais_projetointegrador_grupo2_genbr.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mentalmais_projetointegrador_grupo2_genbr.model.Postagem


class PostagemAdapter: RecyclerView.Adapter<PostagemAdapter.PostagemViewHolder>() {

    private  var listPostagem = emptyList<Postagem>()

    class PostagemViewHolder(val binding: CardLayoutBinding): RecyclerView.ViewHolder(binding.root){
    }
    // Serve para criar o layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostagemViewHolder {
        return  PostagemViewHolder(CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        )
    }

    override fun onBindViewHolder(holder: PostagemViewHolder, position: Int) {
        val postagem = listPostagem[position]

//        holder.binding.textNome.text = postagem.nome
        holder.binding.textImage.text = postagem.imagem
        holder.binding.textDescricao.text = postagem.descricao
//        holder.binding.textData.text = postagem.data
        holder.binding.textTema.text = postagem.tema.nome
    }

    override fun getItemCount(): Int {
        return listPostagem.size
    }

    fun setList(list: List<Postagem>){
        listPostagem = list
        notifyDataSetChanged()
    }
}