package com.example.ejerciciotcnicorappi.movies.view.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

inline fun AppCompatActivity.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    supportFragmentManager.beginTransaction().func().apply{commit()}