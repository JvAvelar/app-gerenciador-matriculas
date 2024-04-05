package dev.jvitor.gerenciadordematriculas.screens

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dev.jvitor.gerenciadordematriculas.R
import dev.jvitor.gerenciadordematriculas.databinding.ActivityAddAlunoBinding
import dev.jvitor.gerenciadordematriculas.models.Aluno
import dev.jvitor.gerenciadordematriculas.screens.viewmodel.AddViewModel

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddAlunoBinding
    private lateinit var viewModel: AddViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddAlunoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this)[AddViewModel::class.java]

        binding.buttonAdd.setOnClickListener {
            addAluno()
            Log.i("Teste", "Chegou na função de Onclick")
        }
    }

    private fun addAluno() {
        val cpf = binding.editCpf.text.toString()
        val nome = binding.editName.text.toString()
        val esporte = binding.editSport.text.toString()
        val dia = binding.editDay.text.toString()
        viewModel.validacao(applicationContext, Aluno(cpf, nome, esporte, dia))
        limparCampos()
        Log.i("Teste", "Chegou na função addAluno")
    }

    private fun limparCampos() {
        binding.editCpf.text.clear()
        binding.editName.text.clear()
        binding.editSport.text.clear()
        binding.editDay.text.clear()
        Log.i("Teste", "Chegou na função limparCampos")

    }
}