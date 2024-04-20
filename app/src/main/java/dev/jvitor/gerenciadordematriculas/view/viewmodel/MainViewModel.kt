package dev.jvitor.gerenciadordematriculas.view.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.jvitor.gerenciadordematriculas.model.Aluno
import dev.jvitor.gerenciadordematriculas.repository.AlunoRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AlunoRepository(application.applicationContext)

    private val listAlunos = MutableLiveData<List<Aluno>>()
    val alunos: LiveData<List<Aluno>> = listAlunos

    fun getAll(){
        listAlunos.value = repository.getAll()
    }

    fun delete(cpf: String) {
        repository.delete(cpf)
    }

    fun get(cpf: String) : Aluno{
        return repository.get(cpf)
    }
}