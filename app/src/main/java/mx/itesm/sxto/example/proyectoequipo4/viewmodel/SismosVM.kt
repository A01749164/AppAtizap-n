package mx.itesm.sxto.example.proyectoequipo4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.sxto.example.proyectoequipo4.apis.ServicioSismosAPI
import mx.itesm.sxto.example.proyectoequipo4.model.SismosDatos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SismosVM : ViewModel() {
    // Modelo
    private val retrofit by lazy { // El objeto retrofit para instanciar
        //el objeto que se conecta a la red y accede a los servicios definidos
        Retrofit.Builder()
            .baseUrl("https://apisismos20221012123904.azurewebsites.net/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instancia que crea el objeto que realiza la descarga
    private val servicioSismosAPI by lazy {
        retrofit.create(ServicioSismosAPI::class.java)
    }

    // Livedata (Observables)
    val listasismos = MutableLiveData<List<SismosDatos>>()

    fun descargarDatosSismos() {
        println("descargarDatosSismos")
        val call = servicioSismosAPI.descargarDatosSismos() // Crea un objeto para descargar
        call.enqueue(object : Callback<List<SismosDatos>> { // DESCARGA ASÍNCRONA
            override fun onResponse(call: Call<List<SismosDatos>>, response: Response<List<SismosDatos>>) {
                if (response.isSuccessful) {
                    println("Lista sismos: ${response.body()}")
                    // Avisar a la vista (adaptador) que hay datos nuevos
                    listasismos.value = response.body()
                } else {
                    println("Error en los datos: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<SismosDatos>>, t: Throwable) {
                println("Error en la descarga: ${t.localizedMessage}")
            }
        })
    }
}