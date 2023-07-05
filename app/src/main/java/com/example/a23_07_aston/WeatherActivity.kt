package com.example.a23_07_aston

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.a23_07_aston.databinding.ActivityMainBinding
import com.example.a23_07_aston.databinding.ActivityWeatherBinding

class WeatherActivity : AppCompatActivity() {

    val binding by lazy { ActivityWeatherBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0,1,0,"Accueil")
        return super.onCreateOptionsMenu(menu)
    }

    //callback click sur le menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == 1) {
            //détruit l'écran courant
           finish()
        }
        return super.onOptionsItemSelected(item)
    }
}