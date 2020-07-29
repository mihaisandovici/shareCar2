package com.example.sharecar2

import android.R.attr.password
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.parola
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    private val mAuth = FirebaseAuth.getInstance()

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
//

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
            if (parola.text.toString() != parola2.text.toString()) {
                parola2.setError("Parolele nu corespund")
                verificareVerificare = false
            }
            if ((verificareNume == true) && (verificareEmail == true) && (verificareTelefon == true) && (verificareCasa == true) && (verificareFacultate == true) && (verificareParola == true) && (verificareParola2 == true) && (verificareVerificare == true)) {
                register(email.text.toString(), parola.text.toString())
            }
        }
    }

    fun register (email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user: FirebaseUser? = mAuth.currentUser
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        this, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                // ...
            }
    }
}