package com.example.sharecar2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.parola
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        afisare()
    }
    private fun afisare() {
        button.setOnClickListener() {
            var verificareNume = true
            var verificareEmail = true
            var verificareTelefon = true
            var verificareCasa = true
            var verificareFacultate = true
            var verificareParola = true
            var verificareParola2 = true
            var verificareVerificare = true


            if (nume.length() == 0) {
                nume.setError("Campul trebuie completat")
                verificareNume = false
            }
            if (emailregister.length() == 0) {
                emailregister.setError("Campul trebuie completat")
                verificareEmail = false
            }
            if (phone.length() == 0) {
                phone.setError("Campul trebuie completat")
                verificareTelefon = false
            }
            if (acasa.length() == 0) {
                acasa.setError("Campul trebuie completat")
                verificareCasa = false
            }
            if (facultate.length() == 0) {
                facultate.setError("Campul trebuie completat")
                verificareFacultate = false
            }
            if (parola.length() == 0) {
                parola.setError("Campul trebuie completat")
                verificareParola = false
            }
            if (parola2.length() == 0) {
                parola2.setError("Campul trebuie completat")
                verificareParola2 = false
            }
            if (parola.text != parola2.text) {
                parola2.setError("Parolele nu corespund")
                verificareVerificare = false
            }
            if ((verificareNume == true) && (verificareEmail == true) && (verificareTelefon == true) && (verificareCasa == true) && (verificareFacultate == true) && (verificareParola == true) && (verificareParola2 == true) && (verificareVerificare == true)) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}