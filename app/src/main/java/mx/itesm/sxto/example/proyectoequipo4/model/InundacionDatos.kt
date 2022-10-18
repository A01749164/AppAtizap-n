package mx.itesm.sxto.example.proyectoequipo4.model

import com.google.gson.annotations.SerializedName

data class InundacionDatos(
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("hora")
    val hora: String,
    @SerializedName("causa")
    val causa: String,
    @SerializedName("situacion_actual")
    val situacion_actual: String,
    @SerializedName("colonia")
    val colonia: String

)