package com.example.android_development_taskapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_development_taskapp.R
import com.example.android_development_taskapp.models.Tarea

class TareasAdapter(private val listaTareas: List<Tarea>) :
    RecyclerView.Adapter<TareasAdapter.TareaViewHolder>() {

    inner class TareaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tituloTarea: TextView = itemView.findViewById(R.id.textViewTituloTarea)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarea, parent, false)
        return TareaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val tarea = listaTareas[position]
        holder.tituloTarea.text = tarea.titulo
    }

    override fun getItemCount(): Int {
        return listaTareas.size
    }
}