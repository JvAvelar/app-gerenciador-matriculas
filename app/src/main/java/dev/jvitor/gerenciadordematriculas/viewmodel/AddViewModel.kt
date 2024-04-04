package dev.jvitor.gerenciadordematriculas.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dev.jvitor.gerenciadordematriculas.repository.AlunoRepository

class AddViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AlunoRepository(application.applicationContext)


}