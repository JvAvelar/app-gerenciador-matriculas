package dev.jvitor.gerenciadordematriculas.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Aluno(
    @PrimaryKey
    @ColumnInfo(name = "cpf") val cpf: String,
    @ColumnInfo(name = "nome") val name: String,
    @ColumnInfo(name = "esporte") val sport: String,
    @ColumnInfo(name = "dia") val day: String
)
