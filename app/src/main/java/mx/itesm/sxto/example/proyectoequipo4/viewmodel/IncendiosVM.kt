package mx.itesm.sxto.example.proyectoequipo4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.sxto.example.proyectoequipo4.apis.ServicioIncendiosAPI
import mx.itesm.sxto.example.proyectoequipo4.model.IncendiosDatos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IncendiosVM : ViewModel()
{
    // Modelo
    private val retrofit by lazy { // El objeto retrofit para instanciar
        //el objeto que se conecta a la red y accede a los servicios definidos
        Retrofit.Builder()
            .baseUrl("https://apiincendios20221011222101.azurewebsites.net/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instancia que crea el objeto que realiza la descarga
    private val servicioIncendiosAPI by lazy {
        retrofit.create(ServicioIncendiosAPI::class.java)
    }

    // Livedata (Observables)
    val listaincendios = MutableLiveData<List<IncendiosDatos>>()

    fun descargarDatosIncendios() {
        println("descargarDatosReforestacion")
        val call = servicioIncendiosAPI.descargarDatosIncendios() // Crea un objeto para descargar
        call.enqueue(object : Callback<List<IncendiosDatos>> { // DESCARGA ASÍNCRONA
            override fun onResponse(call: Call<List<IncendiosDatos>>, response: Response<List<IncendiosDatos>>) {
                if (response.isSuccessful) {
                    println("Lista incendios: ${response.body()}")
                    // Avisar a la vista (adaptador) que hay datos nuevos
                    listaincendios.value = response.body()
                } else {
                    println("Error en los datos: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<IncendiosDatos>>, t: Throwable) {
                println("Error en la descarga: ${t.localizedMessage}")
            }
        })
    }
}