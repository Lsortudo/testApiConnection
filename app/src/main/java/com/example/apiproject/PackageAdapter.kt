package com.example.apiproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apiproject.model.Response

class PackageAdapter (private val data: List<Response>) : RecyclerView.Adapter<PackageAdapter.MyViewHolder>() {
    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(response: Response) {
            val title = view.findViewById<TextView>(R.id.tvTitle)
            val description = view.findViewById<TextView>(R.id.tvDescription)
            title.text = response.cidade
            description.text = response.descricao
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

}