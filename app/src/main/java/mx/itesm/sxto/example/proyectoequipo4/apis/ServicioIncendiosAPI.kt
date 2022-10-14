package mx.itesm.sxto.example.proyectoequipo4.apis

import mx.itesm.sxto.example.proyectoequipo4.model.IncendiosDatos
import retrofit2.Call
import retrofit2.http.GET

interface ServicioIncendiosAPI {
    @GET("incendios")
    fun descargarDatosIncendios(): Call<List<IncendiosDatos>>
}