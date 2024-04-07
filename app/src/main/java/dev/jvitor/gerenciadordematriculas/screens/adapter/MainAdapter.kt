package dev.jvitor.gerenciadordematriculas.screens.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.jvitor.gerenciadordematriculas.databinding.CardModelBinding
import dev.jvitor.gerenciadordematriculas.models.Aluno
import dev.jvitor.gerenciadordematriculas.screens.viewholder.MainViewHolder

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var listAluno: List<Aluno> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val item = CardModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(item)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
       holder.bind(listAluno[position])
    }

    override fun getItemCount(): Int {
        return listAluno.count()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAlunos(list: List<Aluno>){
        listAluno = list
        notifyDataSetChanged()
    }

}
