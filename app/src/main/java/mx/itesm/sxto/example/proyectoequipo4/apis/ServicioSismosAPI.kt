package mx.itesm.sxto.example.proyectoequipo4.apis

import mx.itesm.sxto.example.proyectoequipo4.model.SismosDatos
import retrofit2.Call
import retrofit2.http.GET

interface ServicioSismosAPI {
    @GET("sismos")
    fun descargarDatosSismos(): Call<List<SismosDatos>>
}