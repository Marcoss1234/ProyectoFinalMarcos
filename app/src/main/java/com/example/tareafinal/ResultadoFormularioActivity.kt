package com.example.tareafinal

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoFormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_formulario)

        // Referencias a las vistas
        val tvPlanetaFavorito: TextView = findViewById(R.id.tvPlanetaFavorito)
        val tvViajeEspacial: TextView = findViewById(R.id.tvViajeEspacial)
        val tvActividadEspacial: TextView = findViewById(R.id.tvActividadEspacial)
        val btnVolver: Button = findViewById(R.id.btnVolver)

        // Obtener datos del Intent
        val planetaFavorito = intent.getStringExtra("planetaFavorito")
        val viajeEspacial = intent.getStringExtra("viajeEspacial")
        val actividadFavorita = intent.getStringExtra("actividadFavorita")

        // Configurar vistas con los datos recibidos
        tvPlanetaFavorito.text = "Planeta Favorito: $planetaFavorito"
        tvViajeEspacial.text = "¿Te gustaría viajar al espacio?: $viajeEspacial"
        tvActividadEspacial.text = "Actividad Favorita en el Espacio: $actividadFavorita"

        // Acción del botón Volver
        btnVolver.setOnClickListener {
            finish() // Cierra esta actividad y vuelve a la anterior
        }
    }
}
