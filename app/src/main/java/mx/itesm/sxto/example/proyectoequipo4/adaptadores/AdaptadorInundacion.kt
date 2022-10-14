package mx.itesm.sxto.example.proyectoequipo4.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.sxto.example.proyectoequipo4.R
import mx.itesm.sxto.example.proyectoequipo4.model.InundacionDatos

class AdaptadorInundacion(private val contexto: Context, var arrInundaciones: Array<InundacionDatos>) :
        RecyclerView.Adapter<AdaptadorInundacion.RenglonInundaciones>()
{
        // Se llama cada vez que se va a poblar un renglon
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RenglonInundaciones {
            val vista = LayoutInflater.from(contexto).inflate(R.layout.renglon_inundaciones, parent, false)
            return RenglonInundaciones(vista)
        }

        // Para poblar un renglón (poner los datos en el renglón 'position')
        override fun onBindViewHolder(holder: RenglonInundaciones, position: Int) {
            val inundacion = arrInundaciones[position]
            holder.set(inundacion)
        }

        // El número de renglones que tendra el recyclerview
        override fun getItemCount(): Int {
            return arrInundaciones.size
        }

        class RenglonInundaciones (var renglonInundaciones: View) : RecyclerView.ViewHolder(renglonInundaciones)
        {
            fun set(inundacion: InundacionDatos) {
                renglonInundaciones.findViewById<TextView>(R.id.EstadoI).text = inundacion.estado
                renglonInundaciones.findViewById<TextView>(R.id.LugarI).text = inundacion.lugar
                renglonInundaciones.findViewById<TextView>(R.id.LatitudI).text = "${inundacion.latitud}"
                renglonInundaciones.findViewById<TextView>(R.id.LongitudI).text = "${inundacion.longitud}"
                renglonInundaciones.findViewById<ImageView>(R.id.imgInundacion).setImageResource(R.drawable.inundacion)
            }
        }


    }
