package mx.itesm.sxto.example.proyectoequipo4.view

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
    }
}