package mx.itesm.sxto.example.proyectoequipo4.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.sxto.example.proyectoequipo4.adaptadores.AdaptadorNoticias
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivityNoticiasBinding
import mx.itesm.sxto.example.proyectoequipo4.model.NoticiasDatos
import mx.itesm.sxto.example.proyectoequipo4.viewmodel.NoticiasVM

class Noticias : AppCompatActivity()
{
    // binding
    private lateinit var binding: ActivityNoticiasBinding
    // ViewModel
    private val viewModel: NoticiasVM by viewModels()
    // Fuente de datos del RecyclerView
    var adaptadorNoticias : AdaptadorNoticias? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticiasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Estoy en noticias")

        configurarRV()
        configurarObservables()
        viewModel.descargarDatosNoticias()
    }

    private fun configurarObservables() {
        viewModel.listanoticias.observe(this) { lista ->
            val listaNoticias = lista.toTypedArray()
            adaptadorNoticias?.arrNoticias = listaNoticias
            adaptadorNoticias?.notifyDataSetChanged() // Recargue todo

        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.descargarDatosNoticias()
    }

    private fun configurarRV() {
        val arrNoticias = arrayOf(NoticiasDatos("DescargandoDatos", "DescargandoDatos",
            "DescargandoDatos", "DescargandoDatos"))
        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        binding.RVNoticias.layoutManager = layout
        adaptadorNoticias = AdaptadorNoticias(this, arrNoticias)
        binding.RVNoticias.adapter = adaptadorNoticias

        val divisor = DividerItemDecoration(this, layout.orientation)
        binding.RVNoticias.addItemDecoration(divisor)
    }
}