package com.example.ejerciciotcnicorappi.movies.view.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImageByUrl(url: String){
    Glide.with(this.context).load(url).into(this)
}