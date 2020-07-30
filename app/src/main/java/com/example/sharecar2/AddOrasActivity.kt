package com.example.sharecar2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_oras.*
import kotlinx.android.synthetic.main.activity_register.*

class AddOrasActivity : AppCompatActivity() {

    val database = FirebaseDatabase.getInstance().reference

    var verificareAddNumeOras = true
    var verificareAddKmOras = true
    var verificareAddCostOras = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_oras)

        addOrasButton.setOnClickListener {

            if(addNumeOras.length()==0){
                addNumeOras.setError("Campul trebuie completat")
                verificareAddNumeOras = false
            }
            else{
                verificareAddNumeOras = true
            }
            if(addKmOras.length()==0){
                addKmOras.setError("Campul trebuie completat")
                verificareAddKmOras = false
            }
            else{
                verificareAddKmOras = true
            }
            if(addCostOras.length()==0){
                addCostOras.setError("Campul trebuie completat")
                verificareAddCostOras = false
            }
            else{
                verificareAddCostOras = true
            }
            if((verificareAddNumeOras == true) && (verificareAddKmOras == true) && (verificareAddCostOras == true)){
                addOrasInDB()
            }
        }
    }


    fun addOrasInDB(){
        val oras = Oras(addNumeOras.text.toString(),addKmOras.text.toString(),addCostOras.text.toString())

        val orasRef = database.child("oras")
        val key = orasRef.push().key ?: ""
        orasRef.child(key).setValue(oras)
        Toast.makeText(applicationContext,"Orasul a fost adaugat cu succes!",Toast.LENGTH_SHORT)


        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }
}