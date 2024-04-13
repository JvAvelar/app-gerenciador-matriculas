package dev.jvitor.gerenciadordematriculas.screens.viewholder

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import dev.jvitor.gerenciadordematriculas.databinding.CardModelBinding
import dev.jvitor.gerenciadordematriculas.models.Aluno

class MainViewHolder(private val bind: CardModelBinding) : RecyclerView.ViewHolder(bind.root) {

    @SuppressLint("SetTextI18n")
    fun bind(aluno: Aluno) {
        bind.textDoName.text = " ${aluno.name}"
        bind.textDoSport.text = " ${aluno.sport}"
        bind.textDoDay.text = " ${aluno.day}/mês"

        bind.iconEdit.setOnClickListener{

        }

        bind.iconDelete.setOnClickListener {

        }

    }

}