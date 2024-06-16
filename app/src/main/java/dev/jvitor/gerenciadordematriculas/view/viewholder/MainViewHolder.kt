package dev.jvitor.gerenciadordematriculas.view.viewholder

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import dev.jvitor.gerenciadordematriculas.databinding.CardModelBinding
import dev.jvitor.gerenciadordematriculas.model.Aluno
import dev.jvitor.gerenciadordematriculas.view.listener.OnAlunoListener

class MainViewHolder(private val bind: CardModelBinding, private val listener: OnAlunoListener ) : RecyclerView.ViewHolder(bind.root) {

    // Altera as informações a serem adicionadas para
    @SuppressLint("SetTextI18n")
    fun bind(aluno: Aluno) {
        bind.textDoName.text = " ${aluno.name}"
        bind.textDoSport.text = " ${aluno.sport}"
        bind.textDoDay.text = " ${aluno.day}/mês"

        bind.iconEdit.setOnClickListener{
            listener.onUpdate(aluno.cpf)
        }

        bind.iconDelete.setOnClickListener {
            listener.onDelete(aluno.cpf)
        }
    }
}