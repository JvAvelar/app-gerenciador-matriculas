package dev.jvitor.gerenciadordematriculas.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.jvitor.gerenciadordematriculas.R
import dev.jvitor.gerenciadordematriculas.databinding.ActivityMainBinding
import dev.jvitor.gerenciadordematriculas.screens.adapter.MainAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = MainAdapter()
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


        binding.btnScreenAdd.setOnClickListener{
            startActivity(Intent(this, AddActivity::class.java ))
        }

        // Layout
     //   binding.recyclerList.layoutManager = LinearLayoutManager(this)

        // adapter
      //  binding.recyclerList.adapter = adapter


    }
}