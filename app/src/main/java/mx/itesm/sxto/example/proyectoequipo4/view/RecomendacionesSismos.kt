package mx.itesm.sxto.example.proyectoequipo4.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivityRecomendacionessismosBinding

class RecomendacionesSismos : AppCompatActivity()
{
    // binding
    private lateinit var binding: ActivityRecomendacionessismosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecomendacionessismosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Estoy en recomendaciones SISMOS")
    }
}