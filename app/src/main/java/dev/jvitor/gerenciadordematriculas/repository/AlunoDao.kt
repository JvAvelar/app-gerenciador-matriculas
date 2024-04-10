package dev.jvitor.gerenciadordematriculas.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import dev.jvitor.gerenciadordematriculas.models.Aluno

@Dao
interface AlunoDao {

    @Insert
    fun insert(aluno: Aluno)

    @Delete
    fun delete(aluno: Aluno)

    @Query("SELECT * FROM Aluno ORDER BY nome ASC")
    fun getAll() : List<Aluno>

    @Query("SELECT * FROM Aluno WHERE cpf = :cpf")
    fun get(cpf: String) : Aluno

    @Update
    fun update(aluno: Aluno)


}