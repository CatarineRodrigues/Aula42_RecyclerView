package br.com.zup.marvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.marvel.databinding.ActivityDetalheBinding
import br.com.zup.marvel.model.Heroi

class DetalheActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalheBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acessarActionBar()
        recuperarHeroiSelecionado()
    }

    private fun acessarActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.detalhes_heroi)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun recuperarHeroiSelecionado() {
        val heroi = intent.getParcelableExtra<Heroi>("Heroi")

        if (heroi != null) {
            binding.tvNomeHeroi.text = heroi.getNome()
            binding.tvInformacaoHeroi.text = heroi.getDescricao()
        }
    }

}