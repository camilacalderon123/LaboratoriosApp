package com.ufps.laboratorio.vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ufps.laboratorio.R

class InicioActivity : AppCompatActivity() {


    lateinit var tab: TabLayout
    lateinit var contenedor: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
    }
}