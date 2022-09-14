package com.example.testapp

import android.app.Activity
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movie=Movie("Toy Story",5)
        binding.btnEjecutar.setOnClickListener{

            downloadThreadException()
            playMedia()

        }
    }
    private fun playMedia(){
        binding.txtExecuting.text=movie.play()
    }
    private fun downloadThreadException(){
        binding.txtDownload.text="Start Downloading"
        val thread=Thread(Runnable {
            Thread.sleep(5000)
            runOnUiThread {
                binding.txtDownload.text="Download finished"
            }
        })
        thread.start()
    }
}