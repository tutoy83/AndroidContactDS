package fr.isen.mignottetheo.androidcontactds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.mignottetheo.androidcontactds.databinding.ActivityHomeBinding
import android.content.Intent
import android.util.Log

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.homeTitle.text = "Hello there !"

    }
}