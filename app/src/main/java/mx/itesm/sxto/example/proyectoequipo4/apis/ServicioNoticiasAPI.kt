package mx.itesm.sxto.example.proyectoequipo4.apis

import mx.itesm.sxto.example.proyectoequipo4.model.NoticiasDatos
import retrofit2.Call
import retrofit2.http.GET

interface ServicioNoticiasAPI {
    @GET("noticias")
    fun descargarDatosNoticias(): Call<List<NoticiasDatos>>
}