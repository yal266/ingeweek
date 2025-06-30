package com.example.ingeweek.repository

import com.example.ingeweek.models.Evento
import com.example.ingeweek.models.EventosResponse
import com.google.gson.Gson

class EventosRepository {

    private val gson = Gson()

    private val eventosJson = """
    {
        "eventos": [
            {
                "titulo": "Acto de Inauguración",
                "hora": "09:00 - 10:00",
                "lugar": "Auditorio de la UNS",
                "descripcion": "Inauguración oficial de la Semana de Ingeniería UNS 2025",
                "tipo": "ceremonia",
                "dia": "lunes"
            },
            {
                "titulo": "Conferencia Presidencial",
                "hora": "10:00 - 11:00", 
                "lugar": "Auditorio Central",
                "descripcion": "Conferencia magistral de apertura",
                "tipo": "charla",
                "dia": "lunes"
            },
            {
                "titulo": "Taller de Emprendimiento",
                "hora": "14:00 - 16:00",
                "lugar": "Aula 201", 
                "descripcion": "Desarrollo de habilidades empresariales",
                "tipo": "taller",
                "dia": "lunes"
            },
            {
                "titulo": "Campeonato Intersescuelas",
                "hora": "09:00 - 17:00",
                "lugar": "Complejo Deportivo UNS",
                "descripcion": "Competencias deportivas entre escuelas",
                "tipo": "competencia",
                "dia": "lunes"
            }
        ]
    }
    """.trimIndent()

    fun getEventos(): List<Evento> {
        return try {
            val response = gson.fromJson(eventosJson, EventosResponse::class.java)
            response.eventos
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun getEventosPorDia(dia: String): List<Evento> {
        return getEventos().filter { it.dia.equals(dia, ignoreCase = true) }
    }

    fun getCompetencias(): List<Evento> {
        return getEventos().filter { it.tipo == "competencia" }
    }
}