package com.example.ejerciciotcnicorappi.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ejerciciotcnicorappi.R

class HomeFragment: Fragment(R.layout.layout_home_fragment) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    companion object{
        fun newInstance() = HomeFragment()
    }
}