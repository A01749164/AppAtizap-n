package mx.itesm.sxto.example.proyectoequipo4.model

import com.google.gson.annotations.SerializedName

data class InfoProtegidos (
        @SerializedName("data")
        val data: List<SismosDatos>
        )