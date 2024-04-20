package dev.jvitor.gerenciadordematriculas.model

class Constants private constructor() {

    object Attributs {
        const val CPF = "cpf"
        const val NAME = "name"
        const val SPORT = "sport"
        const val DAY = "day"

    }

    object Database{
        const val DATABASE_NAME = "aluno-db"
        const val QUERY_ALL = "SELECT * FROM Aluno ORDER BY name ASC"
        const val QUERY_GET = "SELECT * FROM Aluno WHERE cpf = :cpf"

    }

}