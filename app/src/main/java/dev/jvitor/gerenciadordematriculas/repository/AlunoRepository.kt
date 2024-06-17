package dev.jvitor.gerenciadordematriculas.repository

import android.content.Context
import dev.jvitor.gerenciadordematriculas.model.Aluno

class AlunoRepository(context: Context) {

    // Instancia do Banco de Dados
    private val database = AlunoDatabase.getDatabase(context).alunoDao()

    // Responsável por pegar um aluno específico pelo cpf
    fun get(cpf: String) : Aluno{
        return database.get(cpf)
    }

    // Inserir ou alterar alunos
    suspend fun save(aluno: Aluno){
        if (get(aluno.cpf) == null)
            database.insert(aluno)
        else
            database.update(aluno)
    }

    // Pegar todos os alunos cadastrados
    fun getAll() : List<Aluno>{
        return database.getAll()
    }

    // Deletar um aluno específico pelo cpf
   fun delete(cpf: String){
        val aluno = database.get(cpf)
        database.delete(aluno)
    }
}