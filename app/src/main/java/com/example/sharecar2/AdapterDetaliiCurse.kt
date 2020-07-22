package com.example.sharecar2


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterDetaliiCurse(
    val listaCurse: List<CurseEchipa2>
) : RecyclerView.Adapter<CursaViewVH2>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursaViewVH2 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cursacard_layout, parent, false)
        return CursaViewVH2(view)
    }

    override fun getItemCount(): Int {
        return listaCurse.size
    }

    override fun onBindViewHolder(holder: CursaViewVH2, position: Int) {
        holder.setCursa(listaCurse[position])
    }

}

class CursaViewVH2(view: View) : RecyclerView.ViewHolder(view) {

    var orasPlecare: TextView
    var orasDestinatie: TextView
    var oraPlecare: TextView
    var pret: TextView

    init {
        orasPlecare = view.findViewById(R.id.orasPlecare)
        orasDestinatie = view.findViewById(R.id.orasSosire)
        oraPlecare=view.findViewById(R.id.oraPlecare)
        pret=view.findViewById(R.id.pret)

        view.setOnClickListener{
            var intent= Intent (view.context,ShowCurseActivity::class.java)
            intent.putExtra("orasP",orasPlecare.text.toString())
            intent.putExtra("orasD",orasDestinatie.text.toString())
            intent.putExtra("oraP",oraPlecare.text.toString())
            intent.putExtra("cost",pret.text.toString())

            view.context.startActivity(intent)

        }
    }

    fun setCursa(cursa: CurseEchipa2) {
        orasPlecare.text = cursa.orasPlecare
        orasDestinatie.text = cursa.orasSosire
        oraPlecare.text = cursa.ora
        pret.text= cursa.pret

    }


}