package mx.itesm.sxto.example.proyectoequipo4.model

import com.google.gson.annotations.SerializedName

data class InundacionDatos(
    @SerializedName("county")
    val estado: String = "",
    @SerializedName("riverOrSea")
    val lugar: String = "",
    @SerializedName("lat")
    val latitud: Double = 0.0,
    @SerializedName("long")
    val longitud: Double = 0.0
)