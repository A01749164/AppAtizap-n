package mx.itesm.sxto.example.proyectoequipo4.model

import com.google.gson.annotations.SerializedName

data class InfoInundaciones(
    @SerializedName("items")
    val items: List<InundacionDatos>
)
