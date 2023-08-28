package com.example.a23_07_aston

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.a23_07_aston.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Création de notre interface
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    //Création de l'écran
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Affiche une interface graphique
        setContentView(binding.root)
        println("MainActivity.onCreate")

        //callback du clic sur le bouton
        binding.btValidate.setOnClickListener {
            if(binding.rbLike.isChecked) {
                binding.et.setText(binding.rbLike.text)
            }
            else if(binding.rbDislike.isChecked) {
                binding.et.setText(binding.rbDislike.text)
            }

            binding.iv.setImageResource(R.drawable.baseline_flag_24)
        }

        binding.btCancel.setOnClickListener {
            binding.et.setText("")
            binding.rg.clearCheck()

            binding.iv.setImageResource(R.drawable.baseline_delete_forever_24)

        }
    }


    //Callback création du menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0,17,0,"Météo")
        menu.add(0,18,0,"Dogs")
        return super.onCreateOptionsMenu(menu)
    }

    //callback click sur le menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == 17) {
            //Lancer le workflow du changement d'écran
            startActivity(Intent(this, WeatherActivity::class.java))
        }
        if(item.itemId == 18) {
            //Lancer le workflow du changement d'écran
            startActivity(Intent(this, DogsActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }


}

