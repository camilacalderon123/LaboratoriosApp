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
import com.ufps.laboratorio.modelo.Noticia

//mapear los elementos
class NoticiaAdapter (val context: Context?, val dataSet: ArrayList<Noticia>, val recurso:Int): RecyclerView.Adapter<NoticiaAdapter.NoticiaViewHolder>(){
    class NoticiaViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tituloNoticia: TextView
        val descripcionNoticia: TextView
        val imagenNoticia: ImageView
        init{
            tituloNoticia = view.findViewById(R.id.tituloNoticia)
            descripcionNoticia = view.findViewById(R.id.descripcionNoticia)
            imagenNoticia = view.findViewById(R.id.imagenNoticia)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(recurso, parent, false)
        return NoticiaViewHolder(view)

    }

    override fun onBindViewHolder(holder: NoticiaViewHolder, position: Int) {
        holder.tituloNoticia.text = dataSet.get(position).tituloNoticia
        holder.descripcionNoticia.text = dataSet.get(position).descripcionNoticia
        Picasso.get().load(dataSet.get(position).imagenNoticia).into(holder.imagenNoticia);

    }

    override fun getItemCount() = dataSet.size
}