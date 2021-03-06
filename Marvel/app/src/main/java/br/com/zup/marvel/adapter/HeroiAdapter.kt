package br.com.zup.marvel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.marvel.*
import br.com.zup.marvel.databinding.HeroiItemBinding
import br.com.zup.marvel.model.Heroi

class HeroiAdapter(
    private var listaHeroi: MutableList<Heroi>,
    private val clickHeroi: (heroi: Heroi) -> Unit
) : RecyclerView.Adapter<HeroiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HeroiItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val heroi = listaHeroi[position]
        holder.exibirInformacoesView(heroi)
        // setar a ideia de clique no card, depois chama a função e passa o heroi da l22
        // a logica disso vai ser la na main
        holder.binding.cvCardHeroi.setOnClickListener {
            clickHeroi(heroi)
        }
    }

    override fun getItemCount(): Int {
        return listaHeroi.size
    }

    fun atualizarListaProduto(novaLista: MutableList<Heroi>) {
        if (listaHeroi.size == 0) {
            listaHeroi = novaLista
        } else {
            listaHeroi.addAll(novaLista)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: HeroiItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun exibirInformacoesView(heroi: Heroi) {
            binding.rvNomeHeroi.text = heroi.getNome()
        }
    }
}