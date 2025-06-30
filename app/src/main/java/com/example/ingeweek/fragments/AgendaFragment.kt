package com.example.ingeweek.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ingeweek.R
import com.example.ingeweek.adapters.EventosAdapter
import com.example.ingeweek.repository.EventosRepository

class AgendaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EventosAdapter
    private val repository = EventosRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_agenda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView(view)
        loadEventos()
    }

    private fun setupRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewEventos)
        adapter = EventosAdapter(emptyList())

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun loadEventos() {
        val eventos = repository.getEventosPorDia("lunes")
        adapter.updateEventos(eventos)
    }
}