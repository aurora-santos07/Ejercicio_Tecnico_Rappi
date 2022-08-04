package com.example.ejerciciotcnicorappi.view.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImageByUrl(url: String){
    Glide.with(this.context).load(url).into(this)
}