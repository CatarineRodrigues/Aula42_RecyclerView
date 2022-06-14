package br.com.zup.zoologico.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.zoologico.R
import br.com.zup.zoologico.adapter.AnimalAdapter
import br.com.zup.zoologico.databinding.FragmentCadastrarBinding
import br.com.zup.zoologico.home.MainActivity
import br.com.zup.zoologico.model.Animal

class CadastrarFragment : Fragment() {

    private lateinit var binding: FragmentCadastrarBinding
    private lateinit var nome: String
    private lateinit var descricao: String
    private val animalAdapter: AnimalAdapter by lazy {
        AnimalAdapter(arrayListOf(), ::irParaDetalhesAnimal)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastrarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clicarBotaoAdicionar()
        exibirRecyclerView()
    }

    private fun adicionarItemListaAnimal() {
        val listaNovaAnimal = mutableListOf<Animal>()
        recuperarDados()
        if (!verificarCampos()) {
            val animal = Animal(
                nome = nome,
                descricao = descricao
            )
            listaNovaAnimal.add(animal)
            animalAdapter.atualizarListaAnimal(listaNovaAnimal)
            Toast.makeText(context, "Animal Cadastrado", Toast.LENGTH_LONG).show()
        }
    }

    private fun clicarBotaoAdicionar() {
        binding.btnAdicionar.setOnClickListener {
            adicionarItemListaAnimal()
            limparCampos()
        }
    }

    private fun recuperarDados() {
        this.nome = binding.etNomeAnimal.text.toString()
        this.descricao = binding.etDescricaoAnimal.text.toString()
    }

    private fun limparCampos() {
        binding.etNomeAnimal.text.clear()
        binding.etDescricaoAnimal.text.clear()
    }

    fun verificarCampos(): Boolean {
        val context = context as MainActivity
        return if (nome.isEmpty() || descricao.isEmpty()) {
            Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            true
        } else {
            false
        }
    }

    private fun irParaDetalhesAnimal(animal: Animal) {
        val bundle = bundleOf("Animal" to animal)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_cadastrarFragment_to_detalheFragment, bundle
        )
    }

    private fun exibirRecyclerView() {
        binding.rvListaAnimal.adapter = animalAdapter
        binding.rvListaAnimal.layoutManager = LinearLayoutManager(context)
    }
}