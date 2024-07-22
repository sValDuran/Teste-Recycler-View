package com.example.dadosimportantes.view

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dadosimportantes.R
import com.example.dadosimportantes.model.AlgoImportante

class MainActivity : AppCompatActivity(), DeleteClickListener {

    private val datasource = ArrayList<AlgoImportante>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findById()
        setupRecyclerView()
        setupListener()
    }

    override fun onDeleteItemClick(position: Int) {
        datasource.removeAt(position)
        val adapter = recyclerView.adapter
        adapter?.notifyDataSetChanged()
    }

    private fun findById(){
        recyclerView = findViewById(R.id.recycler_view)
        buttonAdd = findViewById(R.id.button_add)
    }

    private fun setupRecyclerView(){
        val layoutManager: RecyclerView.LayoutManager
        layoutManager = LinearLayoutManager(this)

        val adapter = AlgoImportanteAdapter(datasource, this)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun setupListener(){
        buttonAdd.setOnClickListener{
            val algoImportante = AlgoImportante()
            datasource.add(algoImportante)

            val adapter = recyclerView.adapter
            adapter?.notifyDataSetChanged()
        }
    }
}