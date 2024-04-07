package dev.jvitor.gerenciadordematriculas.screens.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dev.jvitor.gerenciadordematriculas.models.Aluno
import dev.jvitor.gerenciadordematriculas.repository.AlunoRepository

class UpdateViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AlunoRepository(application.applicationContext)

    private var cpf = MutableLiveData<String>()

    fun cpf(): LiveData<String> {
        return cpf
    }

    fun get(cpf: String) : String {
        val al = repository.get(cpf)
        return al.cpf
    }

    fun update(aluno: Aluno){
        repository.update(aluno)
    }

}