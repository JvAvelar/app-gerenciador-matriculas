package dev.jvitor.gerenciadordematriculas.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dev.jvitor.gerenciadordematriculas.R
import dev.jvitor.gerenciadordematriculas.databinding.ActivityUpdateBinding
import dev.jvitor.gerenciadordematriculas.model.Aluno
import dev.jvitor.gerenciadordematriculas.model.Constants
import dev.jvitor.gerenciadordematriculas.view.viewmodel.UpdateViewModel

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private lateinit var viewModel: UpdateViewModel
    private lateinit var cpf: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this)[UpdateViewModel::class.java]

        binding.buttonUpdate.setOnClickListener {
            doUpdate()
        }

        valuesFields()

    }

    fun doUpdate() {
        val name = binding.editName.text.toString()
        val sport = binding.editSport.text.toString()
        val day = binding.editDay.text.toString()
        if (viewModel.validation(
                applicationContext.applicationContext,
                Aluno(cpf, name, sport, day)
            )
        )
            finish()
        else
            return
    }

    // Atribuindo os valores da intent recebida da MainActivity para ser mostrada nos hints
    private fun valuesFields() {
        cpf = intent?.extras?.getString(Constants.Attributs.CPF) ?: throw IllegalStateException(getString(R.string.cpfNotFound))
        val name = intent?.extras?.getString(Constants.Attributs.NAME) ?: throw IllegalStateException(getString(R.string.nameNotFound))
        val sport = intent?.extras?.getString(Constants.Attributs.SPORT) ?: throw IllegalStateException(getString(R.string.sportNotFound))
        val day = intent?.extras?.getString(Constants.Attributs.DAY) ?: throw IllegalStateException(getString(R.string.dayNotFound))

        binding.editCpf.setText(cpf)
        binding.editName.setText(name)
        binding.editSport.setText(sport)
        binding.editDay.setText(day)
    }
}