package mx.itesm.sxto.example.proyectoequipo4.model

import com.google.gson.annotations.SerializedName

data class NoticiasDatos(
    @SerializedName("titulo")
    val titulo: String,
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("autor")
    val autor: String,
    @SerializedName("descripcion")
    val descripcion: String
)
