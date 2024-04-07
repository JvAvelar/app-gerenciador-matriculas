package dev.jvitor.gerenciadordematriculas.screens.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dev.jvitor.gerenciadordematriculas.models.Aluno
import dev.jvitor.gerenciadordematriculas.repository.AlunoRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AlunoRepository(application.applicationContext)

    fun getAll(): List<Aluno> {
        return repository.getAll()
    }

}