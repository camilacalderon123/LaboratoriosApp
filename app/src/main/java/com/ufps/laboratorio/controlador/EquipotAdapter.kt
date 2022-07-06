package com.ufps.laboratorio.controlador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ufps.laboratorio.R
import com.ufps.laboratorio.modelo.Equipot

class EquipotAdapter (val context: Context?, val dataSet: ArrayList<Equipot>, val recurso:Int): RecyclerView.Adapter<EquipotAdapter.GrupotViewHolder>() {
    class GrupotViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val nombre: TextView
        val cargo: TextView
        val correo: TextView
        val imagen: ImageView
        init{
            nombre = view.findViewById(R.id.tituloNoticia)
            cargo = view.findViewById(R.id.descripcionNoticia)
            correo = view.findViewById(R.id.descripcionNoticia)
            imagen = view.findViewById(R.id.imagenNoticia)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipotAdapter.GrupotViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(recurso, parent, false)
        return EquipotAdapter.GrupotViewHolder(view)

    }

    override fun onBindViewHolder(holder: EquipotAdapter.GrupotViewHolder, position: Int) {
        holder.nombre.text = dataSet.get(position).nombre
        holder.cargo.text = dataSet.get(position).cargo
        holder.correo.text =dataSet.get(position).correo
        Picasso.get().load(dataSet.get(position).imagen).into(holder.imagen);

    }
    override fun getItemCount() = dataSet.size

}
