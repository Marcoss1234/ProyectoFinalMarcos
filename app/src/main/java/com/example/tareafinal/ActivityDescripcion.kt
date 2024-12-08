package com.example.tareafinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tareafinal.databinding.ActivityDescripcionBinding

class ActivityDescripcion : AppCompatActivity() {

    private lateinit var binding: ActivityDescripcionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescripcionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener datos del intent
        val nombre = intent.getStringExtra("NOMBRE") ?: "Sin nombre"
        val descripcion = intent.getStringExtra("DESCRIPCION") ?: "Sin descripción"
        val imagen = intent.getIntExtra("IMAGEN", 0)

        // Mostrar los datos en las vistas
        binding.tvNombreDetalle.text = nombre
        binding.tvDescripcion.text = descripcion
        if (imagen != 0) {
            binding.ivDetalle.setImageResource(imagen)
        }

        // Configurar botón de volver
        binding.btnVolver.setOnClickListener {
            finish() // Finaliza esta actividad y vuelve a la anterior
        }
    }
}
