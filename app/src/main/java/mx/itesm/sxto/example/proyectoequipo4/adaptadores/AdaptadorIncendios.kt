package mx.itesm.sxto.example.proyectoequipo4.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.sxto.example.proyectoequipo4.R
import mx.itesm.sxto.example.proyectoequipo4.model.IncendiosDatos

class AdaptadorIncendios(private val contexto: Context, var arrIncendios: Array<IncendiosDatos>) :
    RecyclerView.Adapter<AdaptadorIncendios.RenglonIncendios>()
{
    // Se llama cada vez que se va a poblar un renglon
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RenglonIncendios {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.renglon_incendios, parent, false)
        return RenglonIncendios(vista)
    }

    // Para poblar un renglón (poner los datos en el renglón 'position')
    override fun onBindViewHolder(holder: RenglonIncendios, position: Int) {
        val incendios = arrIncendios[position]
        holder.set(incendios)
    }


    // El número de renglones que tendra el recyclerview
    override fun getItemCount(): Int {
        return arrIncendios.size
    }

    class RenglonIncendios(var renglonIncendios: View) : RecyclerView.ViewHolder(renglonIncendios) {
        fun set(incendios: IncendiosDatos) {
            renglonIncendios.findViewById<TextView>(R.id.FechaIn).text = incendios.fecha
            renglonIncendios.findViewById<TextView>(R.id.HoraIn).text = incendios.hora
            renglonIncendios.findViewById<TextView>(R.id.CausaIn).text = incendios.causa
            renglonIncendios.findViewById<TextView>(R.id.SituacionIn).text = incendios.situacion
            renglonIncendios.findViewById<TextView>(R.id.LugarIn).text = incendios.lugar
            renglonIncendios.findViewById<ImageView>(R.id.imgIncendios).setImageResource(R.drawable.incendios)
        }
    }
}