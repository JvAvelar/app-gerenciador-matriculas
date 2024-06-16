package dev.jvitor.gerenciadordematriculas.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.jvitor.gerenciadordematriculas.databinding.CardModelBinding
import dev.jvitor.gerenciadordematriculas.model.Aluno
import dev.jvitor.gerenciadordematriculas.view.listener.OnAlunoListener
import dev.jvitor.gerenciadordematriculas.view.viewholder.MainViewHolder

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var listAluno: List<Aluno> = listOf()
    private lateinit var listener: OnAlunoListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val item = CardModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(item, listener)
    }

    // Adiciona o aluno que está na posição à tela
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
       holder.bind(listAluno[position])
    }

    // Responsável por retornar a quantidade de elementos vai ter na tela
    override fun getItemCount(): Int {
        return listAluno.count()
    }

    // Recebe e atualiza os alunos vindo do banco de dados
    @SuppressLint("NotifyDataSetChanged")
    fun updateAlunos(list: List<Aluno>){
        listAluno = list
        notifyDataSetChanged()
    }

    // Responsável por passar o listener para o viewHolder
    fun attachListener(alunoListener: OnAlunoListener){
        listener = alunoListener
    }
}
