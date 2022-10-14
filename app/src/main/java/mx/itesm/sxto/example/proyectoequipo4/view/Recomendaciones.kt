package mx.itesm.sxto.example.proyectoequipo4.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivityRecomendacionesBinding

class Recomendaciones : AppCompatActivity()
{
    // binding
    private lateinit var binding: ActivityRecomendacionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecomendacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Estoy en recomendaciones")

        registrarEventos()
    }

    private fun registrarEventos() {
        // Boton que nos manda a la vista principal
        binding.btnRegresarRecomendaciones.setOnClickListener {
            println("Voy a menú")
            val intMenu = Intent(this, MainActivity::class.java)
            startActivity(intMenu)
        }
    }
}