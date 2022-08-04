package com.example.ejerciciotcnicorappi.movies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejerciciotcnicorappi.App
import com.example.ejerciciotcnicorappi.R
import com.example.ejerciciotcnicorappi.databinding.ActivityMainBinding
import com.example.ejerciciotcnicorappi.movies.view.extensions.inTransaction
import com.example.ejerciciotcnicorappi.movies.view.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeFragment by lazy {HomeFragment.newInstance()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        injectDependency()
        inTransaction { replace(R.id.main_container, homeFragment) }
    }

    private fun injectDependency(){
        App.instance.component.inject(this)
    }



}