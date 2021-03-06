package com.example.sharecar2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_cursa.*
import kotlinx.android.synthetic.main.activity_curse.*
import kotlinx.android.synthetic.main.activity_search.*


class CurseActivity : AppCompatActivity() {

    val database = FirebaseDatabase.getInstance().reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curse)
        val layoutManager = LinearLayoutManager(this)

        lista_curse_2.layoutManager = layoutManager
        lista_curse_2.adapter = AdapterDetaliiCurse(listaCurse)

        add_curse.setOnClickListener{
            addCurseInDatabase()
        }
        addCursa.setOnClickListener{
            addCursaInDbScreen()
        }

    }

    fun addCurseInDatabase() {

        val curseRef = database.child("curse")

        var id = 0
        listaCurse.map { cursa ->
            val key = curseRef.push().key ?: ""
            curseRef.child(key).setValue(cursa)
            id++
        }

//        for (i in 0 until listaCurse.size) {
//            listaCurse[i]
//        }

        val ref = database.child("curse")
    }
    fun addCursaInDbScreen() {
        val intent = Intent(this,AddCursa::class.java)
        startActivity(intent)
    }


    val listaCurse = listOf<CurseEchipa2>(
        CurseEchipa2("Banesti", "Brasov", "05:30","123 lei"),
        CurseEchipa2("Brasov", "Constanta", "12:09","432 lei"),
        CurseEchipa2("Bucuresti", "Focsani", "13:30","243 lei"),
        CurseEchipa2("Mures", "Sibiu", "06:30","145 lei"),
        CurseEchipa2("Ploiesti", "Pitesti", "18:45","50lei"),
        CurseEchipa2("Calarasi", "Sf. Gheorghe", "19:30","321 lei"),
        CurseEchipa2("Tulcea", "Timisoara", "15:40","353 lei"),
        CurseEchipa2("Constanta", "Satu Mare", "14:40","743 lei"),
        CurseEchipa2("Ploiesti", "Constanta","17:23","432 lei")
    )
}