package mx.itesm.sxto.example.proyectoequipo4.model

import com.google.gson.annotations.SerializedName

data class IncendiosDatos (
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("hora")
    val hora: String,
    @SerializedName("causa")
    val causa: String,
    @SerializedName("situacion")
    val situacion: String,
    @SerializedName("lugar")
    val lugar: String
        )
