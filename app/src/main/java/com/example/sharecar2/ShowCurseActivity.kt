package com.example.sharecar2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_curse.*

class ShowCurseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_curse)
        val orasPlecare = intent.getStringExtra("orasP")
        home.text=orasPlecare
        val orasSosire = intent.getStringExtra("orasD")
        destination.text=orasSosire
        val oraPlecare = intent.getStringExtra("oraP")
        clock.text=oraPlecare
        val pret = intent.getStringExtra("cost")
        cash.text=pret
    }

}