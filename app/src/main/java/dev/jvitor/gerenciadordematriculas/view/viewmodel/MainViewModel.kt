package dev.jvitor.gerenciadordematriculas.view.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dev.jvitor.gerenciadordematriculas.model.Aluno
import dev.jvitor.gerenciadordematriculas.repository.AlunoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(application: Application) : AndroidViewModel(application) {

    // Instancia do repositorio
    private val repository = AlunoRepository(application.applicationContext)

    // Observadores para lista de alunos
    private val _alunos = MutableStateFlow<List<Aluno>>(emptyList())
    val alunos = _alunos.asStateFlow()

    // Pegar a lista com todos os alunos do banco de dados
    fun getAll() {
        _alunos.value = repository.getAll()
    }

    // Deletar alunos do banco de dados
    fun delete(cpf: String) {
        repository.delete(cpf)
    }

    // Pegar um aluno com cpf
    fun get(cpf: String): Aluno {
        return repository.get(cpf)
    }
}