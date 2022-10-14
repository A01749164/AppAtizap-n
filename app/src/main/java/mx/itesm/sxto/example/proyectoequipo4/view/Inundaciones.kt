package mx.itesm.sxto.example.proyectoequipo4.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.sxto.example.proyectoequipo4.adaptadores.AdaptadorInundacion
import mx.itesm.sxto.example.proyectoequipo4.databinding.ActivityInundacionesBinding
import mx.itesm.sxto.example.proyectoequipo4.model.InundacionDatos
import mx.itesm.sxto.example.proyectoequipo4.viewmodel.InundacionesVM

class Inundaciones : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityInundacionesBinding
    // ViewModel
    private val viewModel: InundacionesVM by viewModels()
    // Fuente de datos del RecyclerView
    var adaptadorInundacion : AdaptadorInundacion? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInundacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Estoy en inundaciones")

        configurarRV()
        configurarObservables()
        viewModel.descargarDatosInundacion()
        registrarEventos()
    }

    private fun configurarObservables() {
        viewModel.listainundacion.observe(this) { lista ->
            val arrInundacion = lista.items.toTypedArray()
            adaptadorInundacion?.arrInundaciones = arrInundacion
            adaptadorInundacion?.notifyDataSetChanged() // Recargue todo

        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.descargarDatosInundacion()
    }

    private fun configurarRV() {
        val arrInundaciones = arrayOf(InundacionDatos("null", "null", 0.0, 0.0))
        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        binding.RVInundaciones.layoutManager = layout
        adaptadorInundacion = AdaptadorInundacion(this, arrInundaciones)
        binding.RVInundaciones.adapter = adaptadorInundacion

        val divisor = DividerItemDecoration(this, layout.orientation)
        binding.RVInundaciones.addItemDecoration(divisor)
    }

    private fun registrarEventos() {
        // Boton que nos manda a la vista principal
        binding.btnRegresarInundaciones.setOnClickListener {
            println("Voy a menú")
            val intMenu = Intent(this, MainActivity::class.java)
            startActivity(intMenu)
        }
        // Boton que nos manda a la vista recomendaciones
        binding.btnRecomendacionesInundaciones.setOnClickListener {
            println("Voy a recomendaciones")
            val intRecomendaciones = Intent(this, Recomendaciones::class.java)
            startActivity(intRecomendaciones)
        }
    }
}