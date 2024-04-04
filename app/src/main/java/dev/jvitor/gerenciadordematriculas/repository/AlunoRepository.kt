package dev.jvitor.gerenciadordematriculas.repository

import android.content.Context
import dev.jvitor.gerenciadordematriculas.models.Aluno

class AlunoRepository(context: Context) {

    private val database = AlunoDatabase.getDatabase(context).alunoDao()

    fun insert(aluno: Aluno){
        database.insert(aluno)
    }

    fun update(aluno: Aluno){
        database.update(aluno)
    }

    fun getAll() : List<Aluno>{
        return database.getAll()
    }

    fun delete(cpf: String){
        val aluno = database.get(cpf)
        database.delete(aluno)
    }
}