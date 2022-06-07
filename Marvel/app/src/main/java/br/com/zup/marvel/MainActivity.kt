package br.com.zup.marvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.marvel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}