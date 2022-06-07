package br.com.zup.marvel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.marvel.databinding.HeroiItemBinding
import br.com.zup.marvel.model.Heroi

class HeroiAdapter(
    private var listaHeroi: MutableList<Heroi>
) : RecyclerView.Adapter<HeroiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HeroiItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val heroi = listaHeroi[position]
        holder.exibirInformacoesView(heroi)
    }

    override fun getItemCount() = listaHeroi.size

    class ViewHolder(val binding: HeroiItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun exibirInformacoesView(heroi: Heroi) {
            binding.rvNomeHeroi.text = heroi.getNome()
        }
    }
}