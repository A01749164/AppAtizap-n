package mx.itesm.sxto.example.proyectoequipo4.apis

import mx.itesm.sxto.example.proyectoequipo4.model.InfoInundaciones
import retrofit2.Call
import retrofit2.http.GET

interface ServicioInundacionesAPI {
    @GET("floodAreas")
    fun descargarDatosInundacion(): Call<InfoInundaciones>
}