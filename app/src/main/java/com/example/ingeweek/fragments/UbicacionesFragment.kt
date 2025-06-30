package com.example.ingeweek.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.ingeweek.R

class UbicacionesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ubicaciones, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Aquí puedes implementar la lógica para mostrar ubicaciones
        val textView = view.findViewById<TextView>(R.id.tvUbicaciones)
        textView.text = "Próximamente: Mapa de ubicaciones de la UNS"
    }
}