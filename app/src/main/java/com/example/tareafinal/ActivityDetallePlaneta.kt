package com.example.tareafinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tareafinal.databinding.ActivityDescripcionBinding
import com.example.tareafinal.model.Planeta

class ActivityDetallePlaneta : AppCompatActivity() {
    private lateinit var binding: ActivityDescripcionBinding
    private lateinit var planeta: Planeta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar la vista usando la clase de binding generada automáticamente
        binding = ActivityDescripcionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar listeners
        setupListeners()

        // Obtener datos del Intent y mostrarlos en la UI
        recogerDatos()
        mostrarDatosPlaneta()
    }

    private fun setupListeners() {
        // Botón "Volver" para finalizar la actividad
        binding.btnVolver.setOnClickListener { finish() }
    }

    private fun recogerDatos() {
        // Recoger datos enviados por el Intent
        val extras = intent.extras
        if (extras != null) {
            val nombre = extras.getString("NOMBRE", "Nombre por defecto")
            val descripcion = extras.getString("DESCRIPCION", "Descripción por defecto")
            val imagen = extras.getInt("IMAGEN", R.drawable.sistema)

            // Crear un objeto Planeta con los datos recibidos
            planeta = Planeta(nombre, descripcion, imagen)
        } else {
            // Valores por defecto si no se envían datos
            planeta = Planeta(
                nombre = "Nombre por defecto",
                descripcion = "Descripción por defecto",
                imagen = R.drawable.sistema
            )
        }
    }

    private fun mostrarDatosPlaneta() {
        // Mostrar los datos del planeta en la interfaz
        binding.tvNombreDetalle.text = planeta.nombre
        binding.tvDescripcion.text = planeta.descripcion
        binding.ivDetalle.setImageResource(planeta.imagen)
    }
}
