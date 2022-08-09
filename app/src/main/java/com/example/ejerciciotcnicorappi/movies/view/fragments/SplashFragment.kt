package com.example.ejerciciotcnicorappi.movies.view.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ejerciciotcnicorappi.R

class SplashFragment: Fragment(R.layout.layout_splash_fragment) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        goToHome()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun goToHome(){
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val actions = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
            findNavController().navigate(actions)
        }, 3000)
    }
}