package com.example.sharecar2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.parola
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        afisare()
        register()
    }

    private fun afisare() {
        Login.setOnClickListener() {
            var aux = 1
            var aux1 = 1

            if (email.length() == 0) {
                email.setError("Campul trebuie completat")
                aux = 0
            } else if (parola.length() == 0) {
                parola.setError("Campul trebuie completat")
                aux1 = 0
            }
            if ((aux == 1) && (aux1 == 1)) {
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun register() {
        Register.setOnClickListener(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        val EMAIL_CODE = "EMAIL_CODE"
    }
}


