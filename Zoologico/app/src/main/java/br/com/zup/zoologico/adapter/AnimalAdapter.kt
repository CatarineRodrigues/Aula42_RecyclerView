package br.com.zup.zoologico.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.zoologico.databinding.AnimalItemBinding
import br.com.zup.zoologico.model.Animal

class AnimalAdapter(
    private var listaAnimal: MutableList<Animal>,
    private val clickAnimal: (animal: Animal) -> Unit
) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AnimalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = listaAnimal[position]
        holder.exibirInformacoesView(animal)
        holder.binding.cvItem.setOnClickListener {
            clickAnimal(animal)
        }
    }

    override fun getItemCount(): Int {
        return listaAnimal.size
    }

    fun atualizarListaAnimal(novaLista: MutableList<Animal>) {
        if (listaAnimal.size == 0) {
            listaAnimal = novaLista
        } else {
            listaAnimal.addAll(novaLista)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: AnimalItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun exibirInformacoesView(animal: Animal) {
            binding.tvNomeAnimal.text = animal.getNome()
        }
    }
}
