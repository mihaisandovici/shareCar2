package com.example.sharecar2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_orase.*
import kotlinx.android.synthetic.main.activity_search.*

class OraseActivity : AppCompatActivity() {

    val database = FirebaseDatabase.getInstance().reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orase)

        val layoutManager = LinearLayoutManager(this)

        lista_orase.layoutManager = layoutManager
        lista_orase.adapter = AdapterOras(listaDeOrase)

        addOras.setOnClickListener {
            addOrasInDbScreen()

        }
    }
    fun addOrasInDbScreen()
    {
        val intent = Intent(this, AddOrasActivity::class.java)
        startActivity(intent)

        /*val orasRef = database.child("oras")

        var id = 0
        listaDeOrase.map { oras ->
            val key = orasRef.push().key ?: ""
            orasRef.child(key).setValue(oras)
            id++
        }

//        for (i in 0 until listaCurse.size) {
//            listaCurse[i]
//        }

       // val ref = database.child("curse")*/
    }

    val listaDeOrase = listOf<Oras>(
        Oras("Ploiesti", "12 Km", "20 Lei"),
        Oras("Ploiesti", "13 Km", "21 Lei"),
        Oras("Ploiesti", "14 Km", "22 Lei"),
        Oras("Ploiesti", "15 Km", "23 Lei"),
        Oras("Ploiesti", "16 Km", "24 Lei"),
        Oras("Ploiesti", "17 Km", "25 Lei"),
        Oras("Ploiesti", "18 Km", "26 Lei"),
        Oras("Ploiesti", "19 Km", "27 Lei"),
        Oras("Ploiesti", "20 Km", "28 Lei")
    )
}