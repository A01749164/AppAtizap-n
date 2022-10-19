package mx.itesm.sxto.example.proyectoequipo4.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.sxto.example.proyectoequipo4.R
import mx.itesm.sxto.example.proyectoequipo4.model.ClimaDatos

class AdaptadorClima(private val contexto: Context, var arrClima: Array<ClimaDatos>) :
    RecyclerView.Adapter<AdaptadorClima.RenglonClima>() {
    // Se llama cada vez que se va a poblar un renglon
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RenglonClima {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.renglon_clima, parent, false)
        return RenglonClima(vista)
    }

    // Para poblar un renglón (poner los datos en el renglón 'position')
    override fun onBindViewHolder(holder: RenglonClima, position: Int) {
        val clima = arrClima[position]
        holder.set(clima)
    }


    // El número de renglones que tendra el recyclerview
    override fun getItemCount(): Int {
        return arrClima.size
    }

    class RenglonClima(var renglonClima: View) : RecyclerView.ViewHolder(renglonClima) {
        fun set(clima: ClimaDatos) {
            renglonClima.findViewById<TextView>(R.id.FechaC).text = clima.fecha
            renglonClima.findViewById<TextView>(R.id.HoraC).text = clima.hora
            renglonClima.findViewById<TextView>(R.id.TemperaturaC).text = clima.temperatura
            renglonClima.findViewById<TextView>(R.id.ClimaActualC).text = clima.clima_actual
            renglonClima.findViewById<TextView>(R.id.PrecipitacionC).text = clima.probabilidad_precipitacion
            renglonClima.findViewById<TextView>(R.id.HumedadC).text = clima.humedad_relativa
            renglonClima.findViewById<ImageView>(R.id.imgClima).setImageResource(R.drawable.clima)
        }
    }
}