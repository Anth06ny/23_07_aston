package com.example.a23_07_aston

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.a23_07_aston.databinding.ActivityWeatherBinding
import com.squareup.picasso.Picasso
import kotlin.concurrent.thread

class WeatherActivity : AppCompatActivity() {

    //ActivityWeatherBinding créé à partir du XML
    val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btLoad.setOnClickListener {

            val city = binding.editTextText.text.toString().trim()
            binding.progressBar.isVisible = true

            thread {
                println("click")
                val data = RequestUtils.loadWeather(city)

                runOnUiThread {
                    binding.tvTexte.text = "Il fait ${data.main.temp}° à ${data.name} avec un vent de ${data.wind.speed} m/s"

                    binding.progressBar.isVisible = false
                    val urlImage = "https://openweathermap.org/img/wn/${data.weather[0].icon}@4x.png"
                    println("urlImage=##$urlImage##")
                    Picasso.get().load(urlImage).into(binding.imageView);

                }

            }

        }
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