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
import com.ufps.laboratorio.controlador.NoticiaAdapter
import com.ufps.laboratorio.modelo.Noticia
import com.ufps.laboratorio.vista.RegistrarNoticiaActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NoticiasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NoticiasFragment : Fragment() {

    lateinit var  contenedorNoticia: RecyclerView
    lateinit var noticiaAdapter: NoticiaAdapter
    lateinit var  database : FirebaseDatabase
    lateinit var  addNoticia: FloatingActionButton
    var   TAG = "NoticiasFragment"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_noticias, container, false)
        contenedorNoticia = view.findViewById(R.id.contenedor_noticias)
        addNoticia = view.findViewById(R.id.add_noticia)
        var linearlayout = LinearLayoutManager(context)

        database = FirebaseDatabase.getInstance()

        linearlayout.orientation = LinearLayoutManager.VERTICAL
        contenedorNoticia.layoutManager = linearlayout
        noticiaAdapter = NoticiaAdapter(context, dataSetFirebase(), R.layout.cardview)
        contenedorNoticia.adapter = noticiaAdapter
        // Inflate the layout for this fragment
        addNoticia.setOnClickListener{irAddNoticia()}
        return view
    }

    private fun irAddNoticia() {

        var intent = Intent(context,RegistrarNoticiaActivity::class.java)
        startActivity(intent)
    }

    private  fun dataSetFirebase(): ArrayList<Noticia> {
        var noticias : ArrayList<Noticia> = ArrayList()
        val myRef = database.getReference()
        // Read from the database
        // Read from the database
        myRef.child("noticias").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()){
                    noticias.clear()
                    for(data in dataSnapshot.children){
                        var noticia = data.getValue(Noticia::class.java)
                        if (noticia != null) {
                            noticias.add(noticia as Noticia)
                        }
                        noticiaAdapter.notifyDataSetChanged()
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
        return noticias
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NoticiasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NoticiasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}