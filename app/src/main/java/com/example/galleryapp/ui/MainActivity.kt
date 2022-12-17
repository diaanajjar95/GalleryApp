package com.example.galleryapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.galleryapp.AppListener
import com.example.galleryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , AppListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun hideProgress() {
        binding.layoutLoading.root.visibility = View.GONE
    }

    override fun showProgress() {
        binding.layoutLoading.root.visibility = View.VISIBLE
    }

    override fun showMessage(message: String?) {
        message?.let {
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
        }
    }

}