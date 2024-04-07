package dev.jvitor.gerenciadordematriculas.screens

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import dev.jvitor.gerenciadordematriculas.R
import dev.jvitor.gerenciadordematriculas.databinding.ActivityUpdateBinding
import dev.jvitor.gerenciadordematriculas.models.Aluno
import dev.jvitor.gerenciadordematriculas.screens.viewmodel.UpdateViewModel

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private lateinit var viewModel: UpdateViewModel
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
        var cpf = binding.editCpf.text.toString()
        cpf = "Valor não editavel"


    }
    fun doUpdate(){
        val cpf = binding.editCpf.toString()
        val name = binding.editName.text.toString()
        val sport = binding.editSport.text.toString()
        val day = binding.editDay.text.toString()
        viewModel.update(Aluno(cpf, name, sport, day))
    }

}