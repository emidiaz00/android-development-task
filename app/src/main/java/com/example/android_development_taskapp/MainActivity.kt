package com.example.android_development_taskapp


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_development_taskapp.adapter.TareasAdapter
import com.example.android_development_taskapp.models.Tarea


class MainActivity : AppCompatActivity() {

    private val listaTareas: MutableList<Tarea> = mutableListOf()
    private lateinit var adapter: TareasAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNuevaTarea = findViewById<Button>(R.id.btnNuevaTarea)
        val recyclerViewTareas = findViewById<RecyclerView>(R.id.recyclerViewTareas)

        // Configura el RecyclerView y su adaptador
        adapter = TareasAdapter(listaTareas)
        recyclerViewTareas.adapter = adapter
        recyclerViewTareas.layoutManager = LinearLayoutManager(this)

        btnNuevaTarea.setOnClickListener {
            val intent = Intent(this, NuevaTareaActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            val titulo = data.getStringExtra("titulo")
            if (!titulo.isNullOrEmpty()) {
                val nuevaTarea = Tarea(titulo)
                listaTareas.add(nuevaTarea)
                adapter.notifyDataSetChanged()
            }
        }
    }


}