package com.example.a23_07_aston

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.a23_07_aston.databinding.ActivityDogsBinding
import kotlin.concurrent.thread

class DogsActivity : AppCompatActivity() {

    //Création de notre interface
    val binding by lazy { ActivityDogsBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btLoad.setOnClickListener {
            thread {
                try {
                    //Je vais chercher mes donénes
                    val oneDog = DogAPI.getDogs().random()

                    runOnUiThread {
                        //Affichage
                        binding.tvName.text = oneDog.origin
                        binding.tvTitle.text = oneDog.breed
                        binding.tvOtherName.text = oneDog.meta.other_names
                        binding.tvNote.text = oneDog.meta.notes
                        binding.tvNote.isVisible = false
                    }
                }catch(e:Throwable) {
                    e.printStackTrace()
                }
            }
        }
    }
}

