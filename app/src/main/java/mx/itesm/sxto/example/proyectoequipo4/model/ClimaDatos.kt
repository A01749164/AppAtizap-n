package mx.itesm.sxto.example.proyectoequipo4.model

import com.google.gson.annotations.SerializedName

data class ClimaDatos(
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("hora")
    val hora: String,
    @SerializedName("temperatura")
    val temperatura: Int,
    @SerializedName("clima_actual")
    val clima_actual: String,
    @SerializedName("probabilidad_de_precipitacion")
    val probabilidad_precipitacion: Double,
    @SerializedName("humedad_relativa")
    val humedad_relativa: Double
    )
