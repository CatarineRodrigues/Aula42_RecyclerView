package br.com.zup.zoologico.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.zoologico.databinding.FragmentDetalheBinding
import br.com.zup.zoologico.model.Animal

class DetalheFragment : Fragment() {
    private lateinit var binding: FragmentDetalheBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalheBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recuperarAnimal()
    }

    private fun recuperarAnimal() {
        val animal = arguments?.getParcelable<Animal>("Animal")
        if (animal != null) {
            exibirAnimal(animal)
        }
    }

    private fun exibirAnimal(animal: Animal){
        binding.tvNomeAnimal.text = animal.getNome()
        binding.tvDescricao.text = animal.getDescricao()
    }
}