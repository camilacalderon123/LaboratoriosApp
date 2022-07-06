package com.ufps.laboratorio

import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import android.widget.TextView
import android.os.Bundle
import com.ufps.laboratorio.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.OnCompleteListener
import android.content.Intent
import android.view.View
import android.widget.Button
import com.ufps.laboratorio.MainActivity

class prueba : AppCompatActivity() {
  /*  var gso: GoogleSignInOptions? = null
    var gsc: GoogleSignInClient? = null
    var nombre: TextView? = null
    var correo: TextView? = null
    var cerrarSesionB: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nombre = findViewById(R.id.nombre)
        correo = findViewById(R.id.correo)
        cerrarSesionB = findViewById(R.id.cerrarSesionB)

        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        gsc = GoogleSignIn.getClient(this, gso!!)

        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {
            val nombrePersona = acct.displayName
            val correoPersona = acct.email
            nombre.setText(nombrePersona)
            correo.setText(correoPersona)
        }
        cerrarSesionB.setOnClickListener(View.OnClickListener { cerrarSesion() })
    }

    fun cerrarSesion() {
        gsc!!.signOut().addOnCompleteListener {
            finish()
            startActivity(Intent(this@InicioActivity, MainActivity::class.java))
        }
    }*/
}