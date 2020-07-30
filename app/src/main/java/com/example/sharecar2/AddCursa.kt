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

class AddCursa : AppCompatActivity() {

    val database = FirebaseDatabase.getInstance().reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_cursa)
        addcursa2.setOnClickListener(){
            addCursaInDb()
        }

}
    fun addCursaInDb(){
        val curseEchipa2 =  CurseEchipa2(orasPlecare.text.toString(),orasSosire.text.toString(),pret.text.toString(),oraPlecare.text.toString())
        val curseEchipa2Ref = database.child("cursa")
        val key = curseEchipa2Ref.push().key ?: ""
        curseEchipa2Ref.child(key).setValue(curseEchipa2)

        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }
}