package mx.itesm.sxto.example.proyectoequipo4.model

import com.google.gson.annotations.SerializedName

data class ClimaDatos(
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("hora")
    val hora: String,
    @SerializedName("temperatura")
    val temperatura: String,
    @SerializedName("clima_actual")
    val clima_actual: String,
    @SerializedName("probabilidad_de_precipitacion")
    val probabilidad_precipitacion: String,
    @SerializedName("humedad_relativa")
    val humedad_relativa: String
    )
