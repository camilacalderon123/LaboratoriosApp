package com.ufps.laboratorio.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.ufps.laboratorio.R
import com.ufps.laboratorio.controlador.EquipotAdapter
import com.ufps.laboratorio.controlador.NoticiaAdapter
import com.ufps.laboratorio.modelo.Equipot
import com.ufps.laboratorio.modelo.Noticia
import com.ufps.laboratorio.vista.RegistrarEquipotActivity
import com.ufps.laboratorio.vista.RegistrarNoticiaActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CursosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EquipotFragment : Fragment() {

    lateinit var  contenedorEquipot: RecyclerView
    lateinit var equipotAdapter: EquipotAdapter
    lateinit var  database : FirebaseDatabase
    lateinit var  addEquipot: FloatingActionButton
    var   TAG = "GrupotFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_equipot, container, false)
        contenedorEquipot = view.findViewById(R.id.contenedor_equipot)
        addEquipot = view.findViewById(R.id.add_equipot)
        var linearlayout = LinearLayoutManager(context)

        database = FirebaseDatabase.getInstance()

        linearlayout.orientation = LinearLayoutManager.VERTICAL
        contenedorEquipot.layoutManager = linearlayout
        equipotAdapter = EquipotAdapter(context, dataSetFirebase(), R.layout.cardview)
        contenedorEquipot.adapter = equipotAdapter
        // Inflate the layout for this fragment
        addEquipot.setOnClickListener{irAddEquipot()}
        return view
    }

    private fun irAddEquipot() {

        var intent = Intent(context, RegistrarEquipotActivity::class.java)
        startActivity(intent)
    }

    private  fun dataSetFirebase(): ArrayList<Equipot> {
        var equipot : ArrayList<Equipot> = ArrayList()
        val myRef = database.getReference()
        // Read from the database
        // Read from the database
        myRef.child("equipo").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()){
                    equipot.clear()
                    for(data in dataSnapshot.children){
                        var equipo = data.getValue(Equipot::class.java)
                        if (equipo != null) {
                            equipot.add(equipo as Equipot)
                        }
                        equipotAdapter.notifyDataSetChanged()
                    }

                }
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        return equipot
    }

}