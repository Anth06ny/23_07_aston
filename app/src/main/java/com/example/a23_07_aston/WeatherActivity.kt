package com.example.a23_07_aston

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.a23_07_aston.databinding.ActivityWeatherBinding
import com.squareup.picasso.Picasso
import kotlin.concurrent.thread

class WeatherActivity : AppCompatActivity() {

    //ActivityWeatherBinding créé à partir du XML
    val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }

    private var data: WeatherBean? = null
    private var errorMessage: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btLoad.setOnClickListener {

            val city = binding.editTextText.text.toString().trim()
            binding.progressBar.isVisible = true

            thread {
                try {
                    data = RequestUtils.loadWeather(city)
                    errorMessage = null
                    runOnUiThread {
                        refreshScreen()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    data = null
                    errorMessage = "Erreur lors du chargement des données météo : ${e.message}"
                    runOnUiThread {
                        refreshScreen()
                    }
                }
            }
        }
    }

    private fun refreshScreen() {
        if (data != null) {
            // Cache le message d'erreur avec une animation
            binding.tvError.visibility = View.GONE
            binding.tvTexte.text = "Il fait ${data!!.main.temp}° à ${data!!.name} avec un vent de ${data!!.wind.speed} m/s"
            val urlImage = "https://openweathermap.org/img/wn/${data!!.weather[0].icon}@4x.png"
            Picasso.get().load(urlImage).into(binding.imageView)
        } else if (!errorMessage.isNullOrEmpty()) {
            // Fait apparaître le message d'erreur avec une animation
            binding.tvError.text = errorMessage
            binding.tvError.visibility = View.VISIBLE
        }

        binding.progressBar.isVisible = false // Cache la progressBar dans tous les cas
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, 1, 0, "Accueil")
        return super.onCreateOptionsMenu(menu)
    }

    //callback click sur le menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == 1) {
            //détruit l'écran courant
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}