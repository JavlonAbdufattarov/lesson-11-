package com.example.lesson11

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button

import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.Repository

private const val PREFERENS_NAME = "prefs_name"
private const val KEY_NAME = "KEY_NAME"

class MainActivity : AppCompatActivity() {

    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)
        val btnSave: Button = findViewById(R.id.btnSave)
        val btnClear: Button = findViewById(R.id.btnClear)
        val textView: TextView = findViewById(R.id.text)

        repository = Repository(this)

        textView.text = repository.getText()

        btnSave.setOnClickListener {
            val text = editText.text.toString()
            repository.saveText(text)
            textView.text = text
        }

        btnClear.setOnClickListener {
            repository.clearText()
            textView.text = ""
        }
    }
}