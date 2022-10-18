package mx.itesm.sxto.example.proyectoequipo4.apis

import mx.itesm.sxto.example.proyectoequipo4.model.InundacionDatos
import retrofit2.Call
import retrofit2.http.GET

interface ServicioInundacionesAPI {
    @GET("inundaciones")
    fun descargarDatosInundacion(): Call<List<InundacionDatos>>
}