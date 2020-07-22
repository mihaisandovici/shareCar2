package com.example.sharecar2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.cos

class AdapterOras(val listaOrase: List<Oras>) : RecyclerView.Adapter<OrasViewVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrasViewVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.oras_layout, parent, false)
        return OrasViewVH(view)
    }

    override fun getItemCount(): Int {
        return listaOrase.size
    }

    override fun onBindViewHolder(holder: OrasViewVH, position: Int) {
        holder.setOras(listaOrase[position])
    }

}

class OrasViewVH(view: View) : RecyclerView.ViewHolder(view) {

    var nume: TextView
    var distanta: TextView
    var cost: TextView

    init {
        nume = view.findViewById<TextView>(R.id.orasN)
        distanta = view.findViewById<TextView>(R.id.km)
        cost =view.findViewById(R.id.cost)

        view.setOnClickListener {
            val intent= Intent(view.context,ShowOrasActivity::class.java)
            intent.putExtra("numeOras",nume.text.toString())
            intent.putExtra("distantaOras",distanta.text.toString())
            intent.putExtra("costOras", cost.text.toString())

            view.context.startActivity(intent)
        }

    }

    fun setOras(oras: Oras) {
        nume.text = " "+oras.orasNume
        distanta.text = " "+oras.orasKm
        cost.text= " "+oras.orasCost
    }


}