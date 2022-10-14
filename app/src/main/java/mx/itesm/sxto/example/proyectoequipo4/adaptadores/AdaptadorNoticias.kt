package mx.itesm.sxto.example.proyectoequipo4.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.sxto.example.proyectoequipo4.R
import mx.itesm.sxto.example.proyectoequipo4.model.NoticiasDatos

class AdaptadorNoticias(private val contexto: Context, var arrNoticias: Array<NoticiasDatos>) :
    RecyclerView.Adapter<AdaptadorNoticias.RenglonNoticias>()
{
    // Se llama cada vez que se va a poblar un renglon
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RenglonNoticias {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.renglon_noticias, parent, false)
        return RenglonNoticias(vista)
    }

    // Para poblar un renglón (poner los datos en el renglón 'position')
    override fun onBindViewHolder(holder: RenglonNoticias, position: Int) {
        val noticias = arrNoticias[position]
        holder.set(noticias)
    }


    // El número de renglones que tendra el recyclerview
    override fun getItemCount(): Int {
        return arrNoticias.size
    }

    class RenglonNoticias(var renglonNoticias: View) : RecyclerView.ViewHolder(renglonNoticias) {
        fun set(noticias: NoticiasDatos) {
            renglonNoticias.findViewById<TextView>(R.id.TituloN).text = noticias.titulo
            renglonNoticias.findViewById<TextView>(R.id.FechaN).text = noticias.fecha
            renglonNoticias.findViewById<TextView>(R.id.AutorN).text = noticias.autor
            renglonNoticias.findViewById<TextView>(R.id.DescripcionN).text = noticias.descripcion
            renglonNoticias.findViewById<ImageView>(R.id.imgNoticias).setImageResource(R.drawable.noticias)
        }
    }
}