package mx.itesm.sxto.example.proyectoequipo4.model

import com.google.gson.annotations.SerializedName

data class SismosDatos(
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("hora")
    val hora: String,
    @SerializedName("lugar")
    val lugar: String,
    @SerializedName("magnitud")
    val magnitud: Double,
    @SerializedName("profundidad")
    val profundidad: Int

)
