package mx.itesm.sxto.example.proyectoequipo4.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivityRecomendacionesinundacionesBinding

class RecomendacionesInundaciones : AppCompatActivity()
{
    // binding
    private lateinit var binding: ActivityRecomendacionesinundacionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecomendacionesinundacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Estoy en recomendaciones INUNDACIONES")
    }
}