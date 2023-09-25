package com.example.android_development_taskapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class NuevaTareaActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_tarea)

        val textInputLayout = findViewById<TextInputLayout>(R.id.textInputLayout)
        val etTask = findViewById<TextInputEditText>(R.id.editText)
        val btnGuardar = findViewById<Button>(R.id.btnGuardarTarea)

        btnGuardar.setOnClickListener {
            val taskEntered = etTask.text.toString().trim()

            if (taskEntered.isEmpty()) {
                textInputLayout.error = "Este campo es obligatorio"
                val errorTextView = textInputLayout.findViewById<TextView>(com.google.android.material.R.id.textinput_error)
                errorTextView?.apply {
                    gravity = Gravity.CENTER
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }
                } else {
                val intent = Intent()
                intent.putExtra("titulo", taskEntered)
                textInputLayout.error = null
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}