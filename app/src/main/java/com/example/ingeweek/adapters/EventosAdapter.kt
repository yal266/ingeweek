package com.example.ingeweek.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ingeweek.R
import com.example.ingeweek.models.Evento
import com.google.android.material.chip.Chip

class EventosAdapter(private var eventos: List<Evento>) :
    RecyclerView.Adapter<EventosAdapter.EventoViewHolder>() {

    class EventoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitulo: TextView = view.findViewById(R.id.tvTitulo)
        val tvHora: TextView = view.findViewById(R.id.tvHora)
        val tvLugar: TextView = view.findViewById(R.id.tvLugar)
        val tvDescripcion: TextView = view.findViewById(R.id.tvDescripcion)
        val chipTipo: Chip = view.findViewById(R.id.chipTipo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_evento, parent, false)
        return EventoViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val evento = eventos[position]

        holder.tvTitulo.text = evento.titulo
        holder.tvHora.text = evento.hora
        holder.tvLugar.text = evento.lugar

        // Descripción
        if (evento.descripcion.isNotEmpty()) {
            holder.tvDescripcion.text = evento.descripcion
            holder.tvDescripcion.visibility = View.VISIBLE
        } else {
            holder.tvDescripcion.visibility = View.GONE
        }

        // Chip tipo
        holder.chipTipo.text = when(evento.tipo) {
            "charla" -> "Charla"
            "competencia" -> "Competencia"
            "ceremonia" -> "Ceremonia"
            "taller" -> "Taller"
            else -> "Evento"
        }

        val chipColor = when(evento.tipo) {
            "charla" -> R.color.chip_charla
            "competencia" -> R.color.chip_competencia
            "ceremonia" -> R.color.chip_ceremonia
            "taller" -> R.color.chip_taller
            else -> R.color.primary_blue
        }

        holder.chipTipo.setChipBackgroundColorResource(chipColor)
    }

    override fun getItemCount() = eventos.size

    fun updateEventos(nuevosEventos: List<Evento>) {
        eventos = nuevosEventos
        notifyDataSetChanged()
    }
}