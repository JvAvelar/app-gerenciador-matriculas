package dev.jvitor.gerenciadordematriculas.view.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dev.jvitor.gerenciadordematriculas.R
import dev.jvitor.gerenciadordematriculas.model.Aluno
import dev.jvitor.gerenciadordematriculas.repository.AlunoRepository
import kotlinx.coroutines.launch

class UpdateViewModel(application: Application) : AndroidViewModel(application) {

    // Instancia do repositorio
    private val repository = AlunoRepository(application.applicationContext)

    // Verifica se os campos estão preenchidos corretamente
    fun validation(context: Context, aluno: Aluno): Boolean {
        return if (!validateName(aluno.name)) {
            Toast.makeText(context, R.string.textErrorName, Toast.LENGTH_SHORT).show()
            false
        } else if (!validateSport(aluno.sport)) {
            Toast.makeText(context, R.string.textErrorSport, Toast.LENGTH_SHORT).show()
            false
        } else if (!validateDay(aluno.day)) {
            Toast.makeText(context, R.string.textErrorDay, Toast.LENGTH_SHORT).show()
            false
        } else {
            viewModelScope.launch {
                repository.save(aluno)
                Toast.makeText(context, R.string.textSucessUpdated, Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    // Faz a validação do nome
    private fun validateName(name: String) =
        (name.isNotBlank() && name.isNotEmpty() && name.length >= 4)

    // Faz a validação do esporte
    private fun validateSport(sport: String) =
        (sport.length >= 3 && sport.isNotBlank() && sport.isNotEmpty())

    // Faz a validação do dia
    private fun validateDay(day: String): Boolean {
        day.replace(".", "").replace("-", "").replace(",", "")
        return (day.toInt() in 1..31 && day.isNotEmpty() && day.isNotBlank())
    }
}