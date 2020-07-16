package com.example.sharecar2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        afisare()

    }

    private fun afisare(){
        Login.setOnClickListener(){
                var aux= 1
                var aux1=1

           if(email.length()==0){
               email.setError("Campul trebuie completat")
                aux= 0
            }
            else if(parola.length()==0){
               parola.setError("Campul trebuie completat")
               aux1= 0
           }
            if ((aux==1) && (aux1==1)){
                Toast.makeText(applicationContext,"Logarea a fost efectuata cu succes",Toast.LENGTH_LONG).show()
            }

        }
    }


    }


