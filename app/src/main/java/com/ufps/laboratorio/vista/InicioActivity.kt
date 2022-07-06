package com.ufps.laboratorio.vista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
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

     var nombre: TextView? = null
     var correo: TextView? = null
     var cerrarSesionB: Button? = null


    lateinit var contenedor: ViewPager
    lateinit var tab:TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)


        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        gsc = GoogleSignIn.getClient(this, gso!!)

        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {
            val nombrePersona = acct.displayName
            val correoPersona = acct.email
            nombre?.setText(nombrePersona)
            correo?.setText(correoPersona)

        }

        cerrarSesionB?.setOnClickListener(View.OnClickListener {
            cerrarSesion()
        })

        //inicializamos las variables
        tab = findViewById(R.id.tab)
        contenedor = findViewById(R.id.contenedor)
        tab.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(this, supportFragmentManager,tab.tabCount)
        contenedor.adapter = adapter
        contenedor.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))
        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                contenedor.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

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