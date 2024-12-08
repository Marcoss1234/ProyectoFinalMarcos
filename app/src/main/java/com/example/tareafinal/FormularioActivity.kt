package com.example.tareafinal

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        // Referencias a las vistas
        val etPlanetaFavorito: EditText = findViewById(R.id.etPlanetaFavorito)
        val rgViajeEspacial: RadioGroup = findViewById(R.id.rgViajeEspacial)
        val spActividadEspacial: Spinner = findViewById(R.id.spActividadEspacial)
        val btnEnviarFormulario: Button = findViewById(R.id.btnEnviarFormulario)

        // Configurar Spinner
        val actividades = arrayOf(
            "Caminar por la Luna",
            "Vivir en Marte",
            "Observar las estrellas",
            "Investigar planetas lejanos"
        )
        val spinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            actividades
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spActividadEspacial.adapter = spinnerAdapter

        // Acción del botón Enviar
        btnEnviarFormulario.setOnClickListener {
            // Obtener valores del formulario
            val planetaFavorito = etPlanetaFavorito.text.toString().trim()
            val viajeEspacialSeleccionado = when (rgViajeEspacial.checkedRadioButtonId) {
                R.id.rbViajeSi -> "Sí"
                R.id.rbViajeNo -> "No"
                else -> "No especificado"
            }
            val actividadFavorita = spActividadEspacial.selectedItem.toString()

            // Verificar si el campo del planeta favorito está vacío
            if (planetaFavorito.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa tu planeta favorito.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Enviar datos a la nueva actividad
            val intent = Intent(this, ResultadoFormularioActivity::class.java)
            intent.putExtra("planetaFavorito", planetaFavorito)
            intent.putExtra("viajeEspacial", viajeEspacialSeleccionado)
            intent.putExtra("actividadFavorita", actividadFavorita)
            startActivity(intent)
            finish()
        }
    }
}
