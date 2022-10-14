package mx.itesm.sxto.example.proyectoequipo4.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.sxto.example.proyectoequipo4.adaptadores.AdaptadorSismos
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivitySismosBinding
import mx.itesm.sxto.example.proyectoequipo4.model.SismosDatos
import mx.itesm.sxto.example.proyectoequipo4.viewmodel.SismosVM

class Sismos : AppCompatActivity()
{
    // binding
    private lateinit var binding: ActivitySismosBinding
    // ViewModel
    private val viewModel: SismosVM by viewModels()
    // Fuente de datos del RecyclerView
    var adaptadorSismos : AdaptadorSismos? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySismosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Estoy en sismos")

        configurarRV()
        configurarObservables()
        viewModel.descargarDatosSismos()
        registrarEventos()
    }

    private fun configurarObservables() {
        viewModel.listasismos.observe(this) { lista ->
            val listaSismos = lista.toTypedArray()
            adaptadorSismos?.arrSismos = listaSismos
            adaptadorSismos?.notifyDataSetChanged() // Recargue todo

        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.descargarDatosSismos()
    }

    private fun configurarRV() {
        val arrSismos = arrayOf(SismosDatos("Null", "null", "null", 0.0, 0.0))
        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        binding.RVSismos.layoutManager = layout
        adaptadorSismos = AdaptadorSismos(this, arrSismos)
        binding.RVSismos.adapter = adaptadorSismos

        val divisor = DividerItemDecoration(this, layout.orientation)
        binding.RVSismos.addItemDecoration(divisor)
    }

    private fun registrarEventos() {
        // Boton que nos manda a la vista principal
        binding.btnRegresarSismos.setOnClickListener {
            println("Voy a menú")
            val intMenu = Intent(this, MainActivity::class.java)
            startActivity(intMenu)
        }
        // Boton que nos manda a la vista recomendaciones
        binding.btnRecomendacionesSismos.setOnClickListener {
            println("Voy a recomendaciones")
            val intRecomendaciones = Intent(this, Recomendaciones::class.java)
            startActivity(intRecomendaciones)
        }
    }
}