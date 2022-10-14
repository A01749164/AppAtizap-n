package mx.itesm.sxto.example.proyectoequipo4.apis

import mx.itesm.sxto.example.proyectoequipo4.model.TraficoDatos
import retrofit2.Call
import retrofit2.http.GET

interface ServicioTraficoAPI {
    @GET("trafico")
    fun descargarDatosTrafico(): Call<List<TraficoDatos>>
}