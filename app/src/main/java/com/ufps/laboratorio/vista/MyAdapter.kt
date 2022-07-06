package com.ufps.laboratorio.vista

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ufps.laboratorio.fragments.EquipotFragment
import com.ufps.laboratorio.fragments.MiperfilFragment
import com.ufps.laboratorio.fragments.NoticiasFragment

class MyAdapter(
    var context: Context,
    fm: FragmentManager,
    val totalTabs: Int): FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> {
                NoticiasFragment()
            }
            1 -> {
                EquipotFragment()
            }
            2 -> {
                MiperfilFragment()
            }
            else -> getItem(position)
        }

    }

}