package com.example.sharecar2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_oras.*

class ShowOrasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_oras)

        val orasNume = intent.getStringExtra("numeOras")
        showNume.text=orasNume
        val orasDistanta = intent.getStringExtra("distantaOras")
        showKm.text=orasDistanta
        val orasCost = intent.getStringExtra("costOras")
        showCost.text=orasCost

    }
}