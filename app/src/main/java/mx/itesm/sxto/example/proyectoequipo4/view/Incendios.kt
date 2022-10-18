package mx.itesm.sxto.example.proyectoequipo4.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.sxto.example.proyectoequipo4.adaptadores.AdaptadorIncendios
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivityIncendiosBinding
import mx.itesm.sxto.example.proyectoequipo4.model.IncendiosDatos
import mx.itesm.sxto.example.proyectoequipo4.viewmodel.IncendiosVM

class Incendios : AppCompatActivity()
{
    // binding
    private lateinit var binding: ActivityIncendiosBinding
    // ViewModel
    private val viewModel: IncendiosVM by viewModels()
    // Fuente de datos del RecyclerView
    var adaptadorIncendios : AdaptadorIncendios? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncendiosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Estoy en incendios")

        configurarRV()
        configurarObservables()
        viewModel.descargarDatosIncendios()
        registrarEventos()
    }

    private fun configurarObservables() {
        viewModel.listaincendios.observe(this) { lista ->
            val listaincendios = lista.toTypedArray()
            adaptadorIncendios?.arrIncendios = listaincendios
            adaptadorIncendios?.notifyDataSetChanged() // Recargue todo

        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.descargarDatosIncendios()
    }

    private fun configurarRV() {
        val arrIncendios = arrayOf(IncendiosDatos("DescargandoDatos", "DescargandoDatos", "DescargandoDatos", "DescargandoDatos", "DescargandoDatos"))
        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        binding.RVIncendios.layoutManager = layout
        adaptadorIncendios = AdaptadorIncendios(this, arrIncendios)
        binding.RVIncendios.adapter = adaptadorIncendios

        val divisor = DividerItemDecoration(this, layout.orientation)
        binding.RVIncendios.addItemDecoration(divisor)
    }

    private fun registrarEventos() {
        // Boton que nos manda a la vista recomendaciones
        binding.btnRecomendacionesIncendios.setOnClickListener {
            println("Voy a recomendaciones")
            val intRecomendaciones = Intent(this, RecomendacionesIncendios::class.java)
            startActivity(intRecomendaciones)
        }
    }
}