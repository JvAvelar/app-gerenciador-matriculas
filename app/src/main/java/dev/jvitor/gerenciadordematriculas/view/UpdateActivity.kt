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

    fun doUpdate(){
        val name = binding.editName.text.toString()
        val sport = binding.editSport.text.toString()
        val day = binding.editDay.text.toString()
        if (viewModel.validation(applicationContext.applicationContext, Aluno(cpf, name, sport, day)))
            finish()
        else
            return
    }

    // Atribuindo os valores da intent recebida da MainActivity para ser mostrada nos hints
    private fun valuesFields(){
        cpf = intent?.extras?.getString("cpf") ?: throw IllegalStateException("cpf not found")
        val name = intent?.extras?.getString("name") ?: throw IllegalStateException("name not found")
        val sport = intent?.extras?.getString("sport") ?: throw IllegalStateException("sport not found")
        val day = intent?.extras?.getString("day") ?: throw IllegalStateException("day not found")

        binding.editCpf.hint = cpf
        binding.editName.hint = name
        binding.editSport.hint = sport
        binding.editDay.hint = day
    }

}