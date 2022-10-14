package mx.itesm.sxto.example.proyectoequipo4.apis

import mx.itesm.sxto.example.proyectoequipo4.model.ClimaDatos
import retrofit2.Call
import retrofit2.http.GET

interface ServicioClimaAPI {
    @GET("clima")
    fun descargarDatosClima(): Call<List<ClimaDatos>>
}