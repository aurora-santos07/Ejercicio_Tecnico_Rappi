package com.example.ejerciciotcnicorappi.movies.view.extensions

fun ArrayList<String>.formatStringList(): String {
    val stringBuilder = StringBuilder()
    for (index: Int in 0 until this.size) {
        if (index == 7){
            break
        }
        stringBuilder.append(this[index]).append(" · ")
    }
    return stringBuilder.toString()
}