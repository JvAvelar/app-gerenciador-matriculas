package dev.jvitor.gerenciadordematriculas.repository

import android.content.Context
import dev.jvitor.gerenciadordematriculas.models.Aluno

class AlunoRepository(context: Context) {

    private val database = AlunoDatabase.getDatabase(context).alunoDao()

    fun get(cpf: String) : Aluno{
        return database.get(cpf)
    }

    fun save(aluno: Aluno){
        if (get(aluno.cpf) == null)
            database.insert(aluno)
        else
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