package dev.jvitor.gerenciadordematriculas.view.listener

interface OnAlunoListener {
    fun onUpdate(cpf: String)
    fun onDelete(cpf: String)
}