package dev.jvitor.gerenciadordematriculas.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import dev.jvitor.gerenciadordematriculas.model.Aluno
import dev.jvitor.gerenciadordematriculas.model.Constants

@Dao
interface AlunoDao {

    @Insert
    fun insert(aluno: Aluno)

    @Delete
    fun delete(aluno: Aluno)

    @Query(Constants.Database.QUERY_ALL)
    fun getAll() : List<Aluno>

    @Query(Constants.Database.QUERY_GET)
    fun get(cpf: String) : Aluno

    @Update
    fun update(aluno: Aluno)

}