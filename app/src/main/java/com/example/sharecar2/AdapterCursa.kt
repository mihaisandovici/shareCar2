package com.example.sharecar2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterCursa(
    val listaCurse: List<Cursa>
) : RecyclerView.Adapter<CursaViewVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursaViewVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cursa_layout, parent, false)
        return CursaViewVH(view)
    }

    override fun getItemCount(): Int {
        return listaCurse.size
    }

    override fun onBindViewHolder(holder: CursaViewVH, position: Int) {
        holder.setCursa(listaCurse[position])
    }

}

class CursaViewVH(view: View) : RecyclerView.ViewHolder(view) {

    var oras1: TextView
    var oras2: TextView

    init {
        oras1 = view.findViewById<TextView>(R.id.oras1)
        oras2 = view.findViewById<TextView>(R.id.oras2)

        view.setOnClickListener{
            oras1.visibility = View.GONE
        }
    }

    fun setCursa(cursa: Cursa) {
        oras1.text = cursa.orasPlecare
        oras2.text = cursa.orasSosire
    }


}