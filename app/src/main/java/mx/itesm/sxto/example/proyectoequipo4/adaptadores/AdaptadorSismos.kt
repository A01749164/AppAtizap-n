package mx.itesm.sxto.example.proyectoequipo4.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.sxto.example.proyectoequipo4.R
import mx.itesm.sxto.example.proyectoequipo4.model.SismosDatos

class AdaptadorSismos(private val contexto: Context, var arrSismos: Array<SismosDatos>) :
    RecyclerView.Adapter<AdaptadorSismos.RenglonSismos>()
{
    // Se llama cada vez que se va a poblar un renglon
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RenglonSismos {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.renglon_sismos, parent, false)
        return RenglonSismos(vista)
    }

    // Para poblar un renglón (poner los datos en el renglón 'position')
    override fun onBindViewHolder(holder: RenglonSismos, position: Int) {
        val sismos = arrSismos[position]
        holder.set(sismos)
    }


    // El número de renglones que tendra el recyclerview
    override fun getItemCount(): Int {
        return arrSismos.size
    }

    class RenglonSismos(var renglonSismos: View) : RecyclerView.ViewHolder(renglonSismos) {
        fun set(sismos: SismosDatos) {
            renglonSismos.findViewById<TextView>(R.id.FechaS).text = sismos.fecha
            renglonSismos.findViewById<TextView>(R.id.HoraS).text = sismos.hora
            renglonSismos.findViewById<TextView>(R.id.LugarS).text = sismos.lugar
            renglonSismos.findViewById<TextView>(R.id.MagnitudS).text = "${sismos.magnitud}"
            renglonSismos.findViewById<TextView>(R.id.ProfundidadS).text = sismos.profundidad
            renglonSismos.findViewById<ImageView>(R.id.imgSismos).setImageResource(R.drawable.sismos)
        }
    }
}
