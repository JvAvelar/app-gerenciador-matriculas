package dev.jvitor.gerenciadordematriculas.view.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dev.jvitor.gerenciadordematriculas.model.Aluno
import dev.jvitor.gerenciadordematriculas.repository.AlunoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AlunoRepository(application.applicationContext)

    private val _alunos = MutableStateFlow<List<Aluno>>(emptyList())
    val alunos = _alunos.asStateFlow()

    fun getAll(){
        _alunos.value = repository.getAll()
    }

    fun delete(cpf: String) {
        repository.delete(cpf)
    }

    fun get(cpf: String) : Aluno{
        return repository.get(cpf)
    }
}