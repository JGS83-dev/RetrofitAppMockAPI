package com.dsm.retrofitappmockapi.clases.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dsm.retrofitappmockapi.R
import com.dsm.retrofitappmockapi.clases.Recursos

class RecursosAdapter (private val context: Context, private val dataSet: List<Recursos>, private val listener:RecursosListener) :
    RecyclerView.Adapter<RecursosAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val lblVerMas: TextView
        val lblMateria: TextView
        val lblDescripcion: TextView

        init {
            lblVerMas = view.findViewById(R.id.lblVerMas)
            lblMateria = view.findViewById(R.id.lblmateria)
            lblDescripcion = view.findViewById(R.id.lblDescripcion)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_layout, viewGroup, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recursos: Recursos = dataSet.get(position)
        holder.lblMateria.setText(recursos.titulo)
        holder.lblDescripcion.setText(recursos.descripcion)

        holder.lblVerMas.setOnClickListener{
            listener.onItemClick(dataSet.get(position))
        }
    }

    interface RecursosListener {
        fun onItemClick(recursos: Recursos)
    }

    override fun getItemCount() = dataSet.size

}