package mx.itesm.sxto.example.proyectoequipo4.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import com.google.firebase.messaging.FirebaseMessaging
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    companion object {
        private const val TAG = "MainActivity"
        private const val NOTIFICATION_REQUEST_CODE = 1234
    }

    // binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registrarEventos()
        hacerSignOut()
        FirebaseMessaging.getInstance().subscribeToTopic("news")
    }

    fun hacerSignOut() {
        AuthUI.getInstance()
            .signOut(this)
        binding.btnCerrarSesion.setOnClickListener{
            val intCerrarSesion = Intent(this, LoginActivity::class.java)
            startActivity(intCerrarSesion)
        }
    }

    private fun registrarEventos() {
        // Boton que nos manda a la vista inundaciones
        binding.btnInundaciones.setOnClickListener{
            println("Voy a inundaciones")
            val intInundaciones = Intent(this, Inundaciones::class.java)
            startActivity(intInundaciones)
        }
        // Boton que nos manda a la vista incendios
        binding.btnIncendios.setOnClickListener{
            println("Voy a incendios")
            val intIncendios = Intent(this, Incendios::class.java)
            startActivity(intIncendios)
        }
        // Boton que nos manda a la vista accidentes
        binding.btnClima.setOnClickListener{
            println("Voy a clima")
            val intClima = Intent(this, Clima::class.java)
            startActivity(intClima)
        }
        // Boton que nos manda a la vista trafico
        binding.btnTrafico.setOnClickListener{
            println("Voy a trafico")
            val intTrafico = Intent(this, Trafico::class.java)
            startActivity(intTrafico)
        }
        // Boton que nos manda a la vista sismos
        binding.btnSismos.setOnClickListener{
            println("Voy a sismos")
            val intSismos = Intent(this, Sismos::class.java)
            startActivity(intSismos)
        }
        // Boton que nos manda a la vista otros
        binding.btnNoticias.setOnClickListener{
            println("Voy a noticias")
            val intNoticias = Intent(this, Noticias::class.java)
            startActivity(intNoticias)
        }
        // Boton que nos manda a la vista sos
        binding.btnSOS.setOnClickListener{
            println("Voy a sos")
            val intSos = Intent(this, SOS::class.java)
            startActivity(intSos)
        }
        // Boton que nos manda a la vista recomendacioens
        binding.btnRecomendaciones.setOnClickListener{
            println("Voy a recomendaciones")
            val intRecomendadciones = Intent(this, Recomendaciones::class.java)
            startActivity(intRecomendadciones)
        }
        // Boton que nos manda a la vista créditos
        binding.btnCreditos.setOnClickListener{
            println("Voy a créditos")
            val intCreditos = Intent(this, Creditos::class.java)
            startActivity(intCreditos)
        }
    }

}