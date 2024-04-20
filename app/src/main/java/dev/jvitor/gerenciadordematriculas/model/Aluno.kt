package dev.jvitor.gerenciadordematriculas.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Aluno(
    @PrimaryKey
    @ColumnInfo(name = Constants.Attributs.CPF) val cpf: String,
    @ColumnInfo(name =  Constants.Attributs.NAME) val name: String,
    @ColumnInfo(name =  Constants.Attributs.SPORT) val sport: String,
    @ColumnInfo(name =  Constants.Attributs.DAY) val day: String
)
