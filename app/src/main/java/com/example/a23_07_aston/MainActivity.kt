package com.example.a23_07_aston

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.a23_07_aston.RequestUtils.loadWeather
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
        menu.add(0,19,0,"Notif now")
        menu.add(0,20,0,"Notif 8s")
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
        else if(item.itemId == 19) {
            //Notif immédiate
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                == PackageManager.PERMISSION_GRANTED
            ) {
                //On a la permission
                NotificationUtils.createInstantNotification(this, "Coucou")
            } else {
                println("Je la demande")
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 0
                )
            }
        }
        else if(item.itemId == 20) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                == PackageManager.PERMISSION_GRANTED
            ) {
                //On a la permission
                NotificationUtils.scheduleNotification(this, "Coucou", 7000)
            } else {
                println("Je la demande")
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 0
                )
            }
        }

        return super.onOptionsItemSelected(item)
    }


}

