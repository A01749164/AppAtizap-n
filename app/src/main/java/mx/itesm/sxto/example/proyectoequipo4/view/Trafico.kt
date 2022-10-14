package mx.itesm.sxto.example.proyectoequipo4.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.sxto.example.proyectoequipo4.adaptadores.AdaptadorTrafico
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivityTraficoBinding
import mx.itesm.sxto.example.proyectoequipo4.model.TraficoDatos
import mx.itesm.sxto.example.proyectoequipo4.viewmodel.TraficoVM

class Trafico : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityTraficoBinding
    // ViewModel
    private val viewModel: TraficoVM by viewModels()
    // Fuente de datos del RecyclerView
    var adaptadorTrafico : AdaptadorTrafico? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTraficoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Estoy en trafico")

        configurarRV()
        configurarObservables()
        viewModel.descargarDatosTrafico()
        registrarEventos()
    }

    private fun configurarObservables() {
        viewModel.listatrafico.observe(this) { lista ->
            val listaTrafico = lista.toTypedArray()
            adaptadorTrafico?.arrTrafico = listaTrafico
            adaptadorTrafico?.notifyDataSetChanged() // Recargue todo

        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.descargarDatosTrafico()
    }

    private fun configurarRV() {
        val arrPoblacion = arrayOf(TraficoDatos("null", "null", "null","null","null"))
        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        binding.RVTrafico.layoutManager = layout
        adaptadorTrafico = AdaptadorTrafico(this, arrPoblacion)
        binding.RVTrafico.adapter = adaptadorTrafico

        val divisor = DividerItemDecoration(this, layout.orientation)
        binding.RVTrafico.addItemDecoration(divisor)
    }

    private fun registrarEventos() {
        // Boton que nos manda a la vista principal
        binding.btnRegresarTrafico.setOnClickListener {
            println("Voy a menú")
            val intMenu = Intent(this, MainActivity::class.java)
            startActivity(intMenu)
        }
    }
}