package com.example.sharecar2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        afisare()
        register()
    }

    private fun afisare() {
        Login.setOnClickListener() {
            var verificareEmail = true
            var veridicareParola = true

            if (email.length() == 0) {
                email.setError("Campul trebuie completat")
                verificareEmail = false
            } else if (parola.length() == 0) {
                parola.setError("Campul trebuie completat")
                veridicareParola = false
            }
            if ((verificareEmail == true) && (veridicareParola == true)) {
                // Toast.makeText(applicationContext,"Logarea a fost efectuata cu succes",Toast.LENGTH_LONG).show()

                login(email = email.text.toString(), pass = parola.text.toString())
            }
        }
    }

    private fun login(email: String, pass: String) {
        auth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this,
                OnCompleteListener<AuthResult?> { task ->
                    if (task.isSuccessful) {
                        val user: FirebaseUser? = auth.getCurrentUser()
                        val intent = Intent(this, SearchActivity::class.java)
                        intent.putExtra(EMAIL_CODE, user?.email )
                        startActivity(intent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(
                            this, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
    }

    private fun register() {
        Register.setOnClickListener() {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        val EMAIL_CODE = "EMAIL_CODE"
    }
}


