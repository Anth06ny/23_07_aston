package com.example.a23_07_aston

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a23_07_aston.databinding.ActivityDogsBinding
import com.example.a23_07_aston.databinding.ActivityMainBinding

class DogsActivity : AppCompatActivity() {

    //Création de notre interface
    val binding by lazy { ActivityDogsBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}