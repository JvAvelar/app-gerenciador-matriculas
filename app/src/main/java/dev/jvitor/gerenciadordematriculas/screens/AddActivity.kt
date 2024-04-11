package dev.jvitor.gerenciadordematriculas.screens

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dev.jvitor.gerenciadordematriculas.R
import dev.jvitor.gerenciadordematriculas.databinding.ActivityAddBinding
import dev.jvitor.gerenciadordematriculas.models.Aluno
import dev.jvitor.gerenciadordematriculas.screens.viewmodel.AddViewModel

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private lateinit var viewModel: AddViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this)[AddViewModel::class.java]

        binding.buttonAdd.setOnClickListener {
            addAluno()
        }
    }

    private fun addAluno() {
        val cpf = binding.editCpf.text.toString()
        val name = binding.editName.text.toString()
        val sport = binding.editSport.text.toString()
        val day = binding.editDay.text.toString()
        viewModel.validation(applicationContext, Aluno(cpf, name, sport, day))
        finish()
    }
}