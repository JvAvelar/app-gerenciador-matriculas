package dev.jvitor.gerenciadordematriculas.view.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import dev.jvitor.gerenciadordematriculas.R
import dev.jvitor.gerenciadordematriculas.model.Aluno
import dev.jvitor.gerenciadordematriculas.repository.AlunoRepository

class AddViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AlunoRepository(application.applicationContext)

    fun validation(context: Context, aluno: Aluno) : Boolean {
       if (!validateCpf(aluno.cpf)) {
           Toast.makeText(context, R.string.textErrorCpf, Toast.LENGTH_SHORT).show()
           return false
       }
        else if (!validateName(aluno.name)) {
           Toast.makeText(context, R.string.textErrorName, Toast.LENGTH_SHORT).show()
           return false
       }
        else if (!validateSport(aluno.sport)) {
           Toast.makeText(context, R.string.textErrorSport, Toast.LENGTH_SHORT).show()
           return false
       }
        else if (!validateDay(aluno.day)) {
           Toast.makeText(context, R.string.textErrorDay, Toast.LENGTH_SHORT).show()
           return false
       }
        else if (cpfRegister(aluno.cpf)) {
           Toast.makeText(context, R.string.textErrorCpfExistent, Toast.LENGTH_SHORT).show()
           return false
       }
        else {
            repository.save(aluno)
            Toast.makeText(context, R.string.textSucessRegister, Toast.LENGTH_SHORT).show()
           return true
        }
    }

    private fun validateCpf(cpfOld: String): Boolean {
        // Remove caracteres não numéricos do CPF
        var cpf = cpfOld
        cpf = cpf.replace("[^0-9]".toRegex(), "")
            .replace("-", "").replace(".", "")

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length != 11) {
            return false
        }

        // Verifica se todos os dígitos são iguais
        var digitosIguais = true
        for (i in 1..10) {
            if (cpf[i] != cpf[0]) {
                digitosIguais = false
                break
            }
        }
        if (digitosIguais) {
            return false
        }

        // Validação dos dígitos verificadores
        var soma = 0
        for (i in 0..8) {
            soma += (10 - i) * (cpf[i].code - '0'.code)
        }
        var digito1 = 11 - soma % 11
        if (digito1 > 9) {
            digito1 = 0
        }
        soma = 0
        for (i in 0..9) {
            soma += (11 - i) * (cpf[i].code - '0'.code)
        }
        var digito2 = 11 - soma % 11
        if (digito2 > 9) {
            digito2 = 0
        }
        return cpf[9].code - '0'.code == digito1 && cpf[10].code - '0'.code == digito2
    }

    private fun cpfRegister(cpf: String): Boolean {
        return if (repository.get(cpf) == null)
            false
        else
            true
    }

    private fun validateName(name: String) =
        (name.isNotBlank() && name.isNotEmpty() && name.length >= 4)

    private fun validateSport(sport: String) =
        (sport.length >= 3 && sport.isNotBlank() && sport.isNotEmpty())

    private fun validateDay(day: String): Boolean {
        day.replace(".", "").replace("-", "").replace(",", "")
        return (day.toInt() in 1..31 && day.isNotEmpty() && day.isNotBlank())
    }
}