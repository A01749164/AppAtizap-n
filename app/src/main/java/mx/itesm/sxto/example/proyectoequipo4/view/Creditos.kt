package mx.itesm.sxto.example.proyectoequipo4.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivityCreditosBinding


class Creditos : AppCompatActivity()
{
    // binding
    private lateinit var binding: ActivityCreditosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreditosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Estoy en créditos")
    }
}