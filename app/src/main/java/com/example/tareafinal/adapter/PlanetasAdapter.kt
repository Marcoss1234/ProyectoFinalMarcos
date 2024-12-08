package com.example.tareafinal

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tareafinal.model.Planeta

class PlanetasAdapter(private val planetas: List<Planeta>) :
    RecyclerView.Adapter<PlanetasAdapter.PlanetaViewHolder>() {

    inner class PlanetaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.tvNombrePlaneta)
        val imagen: ImageView = itemView.findViewById(R.id.imageViewPlaneta)
        val btnDetalle: Button = itemView.findViewById(R.id.btnDetalle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planeta, parent, false)
        return PlanetaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanetaViewHolder, position: Int) {
        val planeta = planetas[position]

        // Asignar datos a las vistas
        holder.nombre.text = planeta.nombre
        holder.imagen.setImageResource(planeta.imagen)

        // Acción para el botón "Ver Detalle"
        holder.btnDetalle.setOnClickListener {
            // Por ejemplo, iniciar una nueva actividad
            val context = holder.itemView.context
            val intent = Intent(context, ActivityDescripcion::class.java)
            intent.putExtra("NOMBRE", planeta.nombre)
            intent.putExtra("DESCRIPCION", planeta.descripcion)
            intent.putExtra("IMAGEN", planeta.imagen)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int = planetas.size
}
