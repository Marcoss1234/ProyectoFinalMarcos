package com.example.tareafinal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.tareafinal.databinding.ActivityMainBinding
import com.example.tareafinal.model.AstronomyPictureResponse
import com.example.tareafinal.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar el diseño usando View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Llamar a la API al iniciar la app
        loadAstronomyPicture()

        // Configurar botón de recarga
        binding.reloadButton.setOnClickListener {
            loadAstronomyPicture()
        }

        // Configurar botón Ver Planetas
        binding.btnRecyclerPlanetas.setOnClickListener {
            val intent = Intent(this, RecyclerPlanetas::class.java)
            startActivity(intent)
        }

        binding.btnMapa.setOnClickListener {
            val intent = Intent(this, MapaActivity::class.java)
            startActivity(intent)
        }


        // Configurar botón Ir al Formulario
        binding.btnFormulario.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        }

        // Configurar botón de logout
        binding.logoutButton.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        val sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", false) // Cambiar el estado a no logeado
        editor.apply()

        // Navegar a LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Cerrar MainActivity
    }

    private fun loadAstronomyPicture() {
        Log.d("LoadPicture", "Fetching new data from NASA API")
        RetrofitInstance.api.getAstronomyPictureOfTheDay("hau3Wf17EohIhh41EnnJLjRiDzSfssfMq9aBLM2y")
            .enqueue(object : Callback<AstronomyPictureResponse> {
                override fun onResponse(
                    call: Call<AstronomyPictureResponse>,
                    response: Response<AstronomyPictureResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val picture = response.body()
                        binding.titleView.text = picture?.title
                        binding.descriptionView.text = picture?.explanation
                        binding.titleView.visibility = View.VISIBLE
                        binding.descriptionView.visibility = View.VISIBLE
                        Glide.with(this@MainActivity)
                            .load(picture?.url)
                            .into(binding.imageView)
                        Log.d("LoadPicture", "Data loaded successfully")
                    } else {
                        Log.e("LoadPicture", "Error: ${response.code()}")
                        Toast.makeText(
                            this@MainActivity,
                            "Error al obtener los datos: ${response.code()}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<AstronomyPictureResponse>, t: Throwable) {
                    Log.e("LoadPicture", "Error de conexión: ${t.message}")
                    Toast.makeText(
                        this@MainActivity,
                        "Error de conexión: ${t.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }
}
