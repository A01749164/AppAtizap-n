package mx.itesm.sxto.example.proyectoequipo4.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.sxto.example.proyectoequipo4.R
import mx.itesm.sxto.example.proyectoequipo4.adaptadores.AdaptadorClima
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivityClimaBinding
import mx.itesm.sxto.example.proyectoequipo4.model.ClimaDatos
import mx.itesm.sxto.example.proyectoequipo4.viewmodel.ClimaVM


class Clima : AppCompatActivity()
{
    // binding
    private lateinit var binding: ActivityClimaBinding
    // ViewModel
    private val viewModel: ClimaVM by viewModels()
    // Fuente de datos del RecyclerView
    var adaptadorClima : AdaptadorClima? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClimaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Estoy clima")

        configurarRV()
        configurarObservables()
        viewModel.descargarDatosClima()
    }

    private fun configurarObservables() {
        viewModel.listaclima.observe(this) { lista ->
            val listaClima = lista.toTypedArray()
            adaptadorClima?.arrClima = listaClima
            adaptadorClima?.notifyDataSetChanged() // Recargue todo

        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.descargarDatosClima()
    }

    private fun configurarRV() {
        val arrClima = arrayOf(ClimaDatos("DescargandoDatos", "DescargandoDatos",
            "DescargandoDatos", "DescargandoDatos",
            "DescargandoDatos", "DescargandoDatos"))
        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        binding.RVClima.layoutManager = layout
        adaptadorClima = AdaptadorClima(this, arrClima)
        binding.RVClima.adapter = adaptadorClima

        val divisor = DividerItemDecoration(this, layout.orientation)
        binding.RVClima.addItemDecoration(divisor)
    }
}