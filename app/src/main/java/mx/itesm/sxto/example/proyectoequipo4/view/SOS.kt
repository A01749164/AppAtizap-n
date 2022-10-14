package mx.itesm.sxto.example.proyectoequipo4.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivitySosBinding

class SOS : AppCompatActivity()
{
    // binding
    private lateinit var binding: ActivitySosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Estoy en sos")

        registrarEventos()
    }

    private fun registrarEventos() {
        // Boton que nos manda a la vista principal
        binding.btnRegresarSOS.setOnClickListener {
            println("Voy a menú")
            val intMenu = Intent(this, MainActivity::class.java)
            startActivity(intMenu)
        }
        // Boton que nos manda a la vista recomendaciones
        binding.btnInfo.setOnClickListener {
            println("Voy a recomendaciones")
            val intRecomendaciones = Intent(this, Recomendaciones::class.java)
            startActivity(intRecomendaciones)
        }
    }
}