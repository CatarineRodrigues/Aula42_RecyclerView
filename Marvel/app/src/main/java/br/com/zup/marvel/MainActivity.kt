package br.com.zup.marvel

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.marvel.adapter.HeroiAdapter
import br.com.zup.marvel.databinding.ActivityMainBinding
import br.com.zup.marvel.model.Heroi

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val heroiAdapter: HeroiAdapter by lazy {
        HeroiAdapter(arrayListOf())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        exibirRecyclerView()
        adicionarHeroiListaHeroi()

        binding.rvListaHerois.setOnClickListener{
            val intent = Intent(this, Detalhe::class.java)
            startActivity(intent)
        }
    }

    private fun adicionarHeroiListaHeroi() {
        val listaNovaHeroi = mutableListOf<Heroi>()
        listaNovaHeroi.add(Heroi(nome = CAPITAO_AMERICA, descricao = DESCICAO_CAPITAO_AMERICA))
        listaNovaHeroi.add(Heroi(nome = HOMEM_DE_FERRO, descricao = DESCICAO_HOMEM_DE_FERRO))
        listaNovaHeroi.add(Heroi(nome = THOR, descricao = DESCICAO_THOR))
        listaNovaHeroi.add(Heroi(nome = HOMEM_ARANHA, descricao = DESCICAO_HOMEM_ARANHA))
        listaNovaHeroi.add(Heroi(nome = DOUTOR_ESTRANHO, descricao = DESCICAO_DOUTOR_ESTRANHO))
        listaNovaHeroi.add(Heroi(nome = HULK, descricao = DESCICAO_HULK))
        listaNovaHeroi.add(Heroi(nome = STAR_LORD, descricao = DESCICAO_STAR_LORD))
        listaNovaHeroi.add(Heroi(nome = ROCKET_RACCOON, descricao = DESCICAO_ROCKET_RACCOON))
        listaNovaHeroi.add(Heroi(nome = GROOT, descricao = DESCICAO_GROOT))
        listaNovaHeroi.add(Heroi(nome = GAMORA, descricao = DESCICAO_GAMORA))

        heroiAdapter.atualizarListaProduto(listaNovaHeroi)
    }

    private fun exibirRecyclerView(){
        binding.rvListaHerois.adapter = heroiAdapter
        binding.rvListaHerois.layoutManager = LinearLayoutManager(this)
    }
}