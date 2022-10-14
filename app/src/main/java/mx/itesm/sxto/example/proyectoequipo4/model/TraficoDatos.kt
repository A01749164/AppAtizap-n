package mx.itesm.sxto.example.proyectoequipo4.model

import com.google.gson.annotations.SerializedName

data class TraficoDatos(
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("hora")
    val hora: String,
    @SerializedName("causa")
    val causa: String,
    @SerializedName("lugar")
    val lugar: String,
    @SerializedName("situacion_actual")
    val situacion_actual: String
)
