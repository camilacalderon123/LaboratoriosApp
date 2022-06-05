package com.ufps.laboratorio.vista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.tabs.TabLayout
import com.ufps.laboratorio.MainActivity
import com.ufps.laboratorio.R

class InicioActivity : AppCompatActivity() {
    var gso: GoogleSignInOptions? = null
    var gsc: GoogleSignInClient? = null
    lateinit var signOutBtn: Button

    lateinit var tab: TabLayout
    lateinit var contenedor: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        signOutBtn = findViewById(R.id.sesion)
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        gsc = GoogleSignIn.getClient(this, gso!!)

        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {
            val nombrePersona = acct.displayName
            val emailPersona = acct.email
        }

        signOutBtn.setOnClickListener(View.OnClickListener {
            cerrarSesion()
        })
    }

    //cerrar sesion
    fun cerrarSesion() {
        gsc!!.signOut().addOnCompleteListener {
            finish()
            startActivity(Intent(this@InicioActivity, MainActivity::class.java))
        }
    }

}