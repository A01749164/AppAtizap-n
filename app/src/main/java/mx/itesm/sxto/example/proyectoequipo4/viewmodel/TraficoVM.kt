package mx.itesm.sxto.example.proyectoequipo4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.sxto.example.proyectoequipo4.apis.ServicioTraficoAPI
import mx.itesm.sxto.example.proyectoequipo4.model.TraficoDatos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TraficoVM: ViewModel() {
    // Modelo
    private val retrofit by lazy { // El objeto retrofit para instanciar
        //el objeto que se conecta a la red y accede a los servicios definidos
        Retrofit.Builder()
            .baseUrl("https://apitrafico20221012130024.azurewebsites.net/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instancia que crea el objeto que realiza la descarga
    private val servicioTraficoAPI by lazy {
        retrofit.create(ServicioTraficoAPI::class.java)
    }

    // Livedata (Observables)
    val listatrafico = MutableLiveData<List<TraficoDatos>>()

    fun descargarDatosTrafico() {
        println("descargarDatosTrafico")
        val call = servicioTraficoAPI.descargarDatosTrafico() // Crea un objeto para descargar
        call.enqueue(object : Callback<List<TraficoDatos>> { // DESCARGA ASÍNCRONA
            override fun onResponse(call: Call<List<TraficoDatos>>, response: Response<List<TraficoDatos>>) {
                if (response.isSuccessful) {
                    println("Lista trafico: ${response.body()}")
                    // Avisar a la vista (adaptador) que hay datos nuevos
                    listatrafico.value = response.body()
                } else {
                    println("Error en los datos: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<TraficoDatos>>, t: Throwable) {
                println("Error en la descarga: ${t.localizedMessage}")
            }
        })
    }
}