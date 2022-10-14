package mx.itesm.sxto.example.proyectoequipo4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.sxto.example.proyectoequipo4.apis.ServicioNoticiasAPI
import mx.itesm.sxto.example.proyectoequipo4.model.NoticiasDatos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NoticiasVM : ViewModel()
{
    // Modelo
    private val retrofit by lazy { // El objeto retrofit para instanciar
        //el objeto que se conecta a la red y accede a los servicios definidos
        Retrofit.Builder()
            .baseUrl("https://apinoticias20221012131633.azurewebsites.net/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instancia que crea el objeto que realiza la descarga
    private val servicioNoticiasAPI by lazy {
        retrofit.create(ServicioNoticiasAPI::class.java)
    }

    // Livedata (Observables)
    val listanoticias = MutableLiveData<List<NoticiasDatos>>()

    fun descargarDatosNoticias() {
        println("descargarDatosNoticias")
        val call = servicioNoticiasAPI.descargarDatosNoticias() // Crea un objeto para descargar
        call.enqueue(object : Callback<List<NoticiasDatos>> { // DESCARGA ASÍNCRONA
            override fun onResponse(call: Call<List<NoticiasDatos>>, response: Response<List<NoticiasDatos>>) {
                if (response.isSuccessful) {
                    println("Lista noticias: ${response.body()}")
                    // Avisar a la vista (adaptador) que hay datos nuevos
                    listanoticias.value = response.body()
                } else {
                    println("Error en los datos: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<NoticiasDatos>>, t: Throwable) {
                println("Error en la descarga: ${t.localizedMessage}")
            }
        })
    }
}