package dev.jvitor.gerenciadordematriculas.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dev.jvitor.gerenciadordematriculas.R
import dev.jvitor.gerenciadordematriculas.databinding.ActivityMainBinding
import dev.jvitor.gerenciadordematriculas.view.adapter.MainAdapter
import dev.jvitor.gerenciadordematriculas.view.listener.OnAlunoListener
import dev.jvitor.gerenciadordematriculas.view.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = MainAdapter()
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Layout
        binding.recyclerList.layoutManager = LinearLayoutManager(this)
        // adapter
        binding.recyclerList.adapter = adapter

        val listener = object : OnAlunoListener {
            override fun onUpdate(cpf: String) {
                val intent = Intent(applicationContext, UpdateActivity::class.java)
                val aluno = viewModel.get(cpf)
                intent.putExtra("cpf", aluno.cpf)
                intent.putExtra("name", aluno.name)
                intent.putExtra("sport", aluno.sport)
                intent.putExtra("day", aluno.day)
                startActivity(intent)
            }

            override fun onDelete(cpf: String) {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle(getString(R.string.deleteAluno))
                    .setMessage(getString(R.string.textConfirmationDelete))
                    .setPositiveButton(getString(R.string.yes)) { dialog, which ->
                        viewModel.delete(cpf)
                        viewModel.getAll()
                    }
                    .setNegativeButton(getString(R.string.no)) { dialog, which -> null }
                    .create()
                    .show()
            }
        }

        observer()

        adapter.attachListener(listener)

        viewModel.getAll()

        binding.btnScreenAdd.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        viewModel.getAll()
        val result = viewModel.quantity()
        binding.textResult.text = " $result"
    }

    private fun observer() {
        viewModel.alunos.observe(this) {
            adapter.updateAlunos(it)
        }
    }
}