package mx.itesm.sxto.example.proyectoequipo4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.sxto.example.proyectoequipo4.apis.ServicioClimaAPI
import mx.itesm.sxto.example.proyectoequipo4.model.ClimaDatos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClimaVM : ViewModel()
{
    // Modelo
    private val retrofit by lazy { // El objeto retrofit para instanciar
        //el objeto que se conecta a la red y accede a los servicios definidos
        Retrofit.Builder()
            .baseUrl("https://apiclima20221012202104.azurewebsites.net/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instancia que crea el objeto que realiza la descarga
    private val servicioClimaAPI by lazy {
        retrofit.create(ServicioClimaAPI::class.java)
    }

    // Livedata (Observables)
    val listaclima = MutableLiveData<List<ClimaDatos>>()

    fun descargarDatosClima() {
        println("descargarDatosClima")
        val call = servicioClimaAPI.descargarDatosClima() // Crea un objeto para descargar
        call.enqueue(object : Callback<List<ClimaDatos>> { // DESCARGA ASÍNCRONA
            override fun onResponse(call: Call<List<ClimaDatos>>, response: Response<List<ClimaDatos>>) {
                if (response.isSuccessful) {
                    println("Lista clima: ${response.body()}")
                    // Avisar a la vista (adaptador) que hay datos nuevos
                    listaclima.value = response.body()
                } else {
                    println("Error en los datos: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<ClimaDatos>>, t: Throwable) {
                println("Error en la descarga: ${t.localizedMessage}")
            }
        })
    }
}