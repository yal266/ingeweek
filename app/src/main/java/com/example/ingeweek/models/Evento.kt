package com.example.ingeweek.models

import com.google.gson.annotations.SerializedName

data class Evento(
    @SerializedName("titulo") val titulo: String,
    @SerializedName("hora") val hora: String,
    @SerializedName("lugar") val lugar: String,
    @SerializedName("descripcion") val descripcion: String,
    @SerializedName("tipo") val tipo: String,
    @SerializedName("dia") val dia: String
)

data class EventosResponse(
    @SerializedName("eventos") val eventos: List<Evento>
)