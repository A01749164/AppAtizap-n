package mx.itesm.sxto.example.proyectoequipo4.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.sxto.example.proyectoequipo4.R
import mx.itesm.sxto.example.proyectoequipo4.model.TraficoDatos

class AdaptadorTrafico(private val contexto: Context, var arrTrafico: Array<TraficoDatos>) :
    RecyclerView.Adapter<AdaptadorTrafico.RenglonTrafico>()
{
    // Se llama cada vez que se va a poblar un renglon
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RenglonTrafico {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.renglon_trafico, parent, false)
        return RenglonTrafico(vista)
    }

    // Para poblar un renglón (poner los datos en el renglón 'position')
    override fun onBindViewHolder(holder: RenglonTrafico, position: Int) {
        val trafico = arrTrafico[position]
        holder.set(trafico)
    }


    // El número de renglones que tendra el recyclerview
    override fun getItemCount(): Int {
        return arrTrafico.size
    }

    class RenglonTrafico(var renglonTrafico: View) : RecyclerView.ViewHolder(renglonTrafico) {
        fun set(trafico: TraficoDatos) {
            renglonTrafico.findViewById<TextView>(R.id.FechaT).text = trafico.fecha
            renglonTrafico.findViewById<TextView>(R.id.HoraT).text = trafico.hora
            renglonTrafico.findViewById<TextView>(R.id.CausaT).text = trafico.causa
            renglonTrafico.findViewById<TextView>(R.id.LugarT).text = trafico.lugar
            renglonTrafico.findViewById<TextView>(R.id.SituacionT).text = trafico.situacion_actual
            renglonTrafico.findViewById<ImageView>(R.id.imgTrafico).setImageResource(R.drawable.trafico)
        }
    }
}