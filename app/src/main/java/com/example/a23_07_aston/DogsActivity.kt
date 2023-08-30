package com.example.a23_07_aston

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a23_07_aston.databinding.ActivityDogsBinding
import kotlin.concurrent.thread

class DogsActivity : AppCompatActivity() {

    //Création de notre interface
    val binding by lazy { ActivityDogsBinding.inflate(layoutInflater) }

    val adapter = DogsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //pour le recyclerView
        binding.rv.adapter = adapter
        //nombr de colonne 0 par défaut
        binding.rv.layoutManager = GridLayoutManager(this, 2)

        binding.btLoad.setOnClickListener {
            thread {
                try {
                    //Je vais chercher mes donénes
                    val dogList = DogAPI.getDogs()
                    val oneDog = dogList.random()

                    runOnUiThread {
                        //Affichage
                        binding.tvName.text = oneDog.origin
                        binding.tvTitle.text = oneDog.breed
                        binding.tvOtherName.text = oneDog.meta.other_names
                        binding.tvNote.text = oneDog.meta.notes
                        binding.tvNote.isVisible = false

                        adapter.submitList(dogList.toList())
                    }
                }catch(e:Throwable) {
                    e.printStackTrace()
                }
            }
        }
    }
}

