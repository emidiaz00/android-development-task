package com.example.android_development_taskapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NuevaTareaActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_tarea)


        val btnGuardar = findViewById<Button>(R.id.btnGuardarTarea)
        val editText = findViewById<EditText>(R.id.editText)

        btnGuardar.setOnClickListener {
            val tituloDeLaTarea = editText.text.toString()

            val intent = Intent()
            intent.putExtra("titulo", tituloDeLaTarea)

            // establecer resultado como result ok y envia el intent

            setResult(RESULT_OK, intent)

            // cerrar actividad

            finish()
        }


    }
}