package dev.jvitor.gerenciadordematriculas.model

open class LogicAux{

    open fun validateName(name: String) =
        (name.isNotBlank() && name.isNotEmpty() && name.length >= 4)

    open fun validateSport(sport: String) =
        (sport.length >= 3 && sport.isNotBlank() && sport.isNotEmpty())

    open fun validateDay(day: String): Boolean {
        day.replace(".", "").replace("-", "").replace(",", "")
        return (day.toInt() in 1..31 && day.isNotEmpty() && day.isNotBlank())
    }

}