package com.example.tareafinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tareafinal.provider.PlanetasProvider

class RecyclerPlanetas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_planetas)

        // Configurar RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewPlanetas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Obtener lista de planetas del Provider
        val planetas = PlanetasProvider.planetas

        // Configurar adaptador
        val adapter = PlanetasAdapter(planetas)
        recyclerView.adapter = adapter
    }
}
