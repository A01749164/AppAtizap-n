package mx.itesm.sxto.example.proyectoequipo4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.sxto.example.proyectoequipo4.model.InfoInundaciones
import mx.itesm.sxto.example.proyectoequipo4.apis.ServicioInundacionesAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InundacionesVM : ViewModel()
{
    // Modelo
    private val retrofit by lazy { // El objeto retrofit para instanciar
        //el objeto que se conecta a la red y accede a los servicios definidos
        Retrofit.Builder()
            .baseUrl("https://environment.data.gov.uk/flood-monitoring/id/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instancia que crea el objeto que realiza la descarga
    private val servicioInundacionesAPI by lazy {
        retrofit.create(ServicioInundacionesAPI::class.java)
    }

    // Livedata (Observables)
    val listainundacion = MutableLiveData<InfoInundaciones>()

    fun descargarDatosInundacion() {
        println("descargarDatosInundacion")
        val call = servicioInundacionesAPI.descargarDatosInundacion() // Crea un objeto para descargar
        call.enqueue(object : Callback<InfoInundaciones> { // DESCARGA ASÍNCRONA
            override fun onResponse(call: Call<InfoInundaciones>, response: Response<InfoInundaciones>) {
                if (response.isSuccessful) {
                    println("Lista inundaciones: ${response.body()}")
                    // Avisar a la vista (adaptador) que hay datos nuevos
                    listainundacion.value = response.body()
                } else {
                    println("Error en los datos: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<InfoInundaciones>, t: Throwable) {
                println("Error en la descarga: ${t.localizedMessage}")
            }
        })
    }
}