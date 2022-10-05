package com.example.mentalmais_projetointegrador_grupo2_genbr

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mentalmais_projetointegrador_grupo2_genbr.model.Postagem
import com.example.mentalmais_projetointegrador_grupo2_genbr.model.Tema
import com.junior.testepi.R

class FormFragment : Fragment() {
    //    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentFormBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    private var temaSelecionado = 0L




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        mainViewModel.listTema()
        mainViewModel.myTemaResponse.observe(viewLifecycleOwner){
                response -> Log.d("requisicao", response.body().toString())
            spinnerTema(response.body())
        }

        binding.buttonPostar.setOnClickListener{
            inserirNoBanco()
        }
        binding.textLegenda

        return binding.root
    }

    private fun spinnerTema(listTema: List<Tema>?){
        if (listTema != null){
            binding.spinnerTema.adapter =
                ArrayAdapter(
                    requireContext(),
                    androidx.transition.R.layout.support_simple_spinner_dropdown_item,
                    listTema
                )

            binding.spinnerTema.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        val selected = binding.spinnerTema.selectedItem as Tema

                        temaSelecionado = selected.id

                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {

                    }

                }
        }
    }
    private fun validarCampos( image: String, descricao: String): Boolean{
        return !( (descricao == "" || descricao.length < 5 || descricao.length > 200) ||
                (image ==  "" || image.length < 10)
                )
    }

    private fun inserirNoBanco(){
        val image = binding.imgLink.text.toString()
        val desc = binding.textLegenda.text.toString()
        val tema = Tema(temaSelecionado, null, null)

        if(validarCampos( desc, image)){
            val postagem = Postagem(0, image, desc, tema)
            mainViewModel.addPost(postagem)
            Toast.makeText(context, "Tarefa criada 😎🍭💅", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }else{
            Toast.makeText(context, "Verique os campos 😢😶‍🌫️🤯", Toast.LENGTH_LONG).show()
        }
    }


}