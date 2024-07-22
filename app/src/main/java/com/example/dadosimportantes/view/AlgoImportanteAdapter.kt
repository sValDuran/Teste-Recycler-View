package com.example.dadosimportantes.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.dadosimportantes.R
import com.example.dadosimportantes.model.AlgoImportante

class AlgoImportanteAdapter(private val dataset: List<AlgoImportante>, val clickListener: DeleteClickListener): RecyclerView.Adapter<AlgoImportanteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.importante_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val algoImportante = dataset[position]
        holder.title.setText("Elemento: ${algoImportante.id}")
        holder.sequence.setText("# ${algoImportante.id}")
        holder.delete.setOnClickListener{
            clickListener.onDeleteItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var title : TextView = view.findViewById(R.id.text_title)
        val sequence : TextView = view.findViewById(R.id.text_sequence)
        val delete: ImageView = view.findViewById(R.id.image_delete)
    }
}