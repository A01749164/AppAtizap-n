package mx.itesm.sxto.example.proyectoequipo4.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivityRecomendacionesincendiosBinding

class RecomendacionesIncendios : AppCompatActivity()
{
    // binding
    private lateinit var binding: ActivityRecomendacionesincendiosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecomendacionesincendiosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Estoy en recomendaciones INCENDIOS")
    }
}