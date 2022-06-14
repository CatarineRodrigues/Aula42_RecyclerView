package br.com.zup.zoologico.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Animal(
    private val nome: String,
    private val descricao: String
) : Parcelable {
    fun getNome() = this.nome
    fun getDescricao() = this.descricao
}