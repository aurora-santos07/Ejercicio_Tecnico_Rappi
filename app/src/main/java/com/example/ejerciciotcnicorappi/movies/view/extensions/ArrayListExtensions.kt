package com.example.ejerciciotcnicorappi.movies.view.extensions

fun ArrayList<String>.formatStringList(): String {
    val stringBuilder = StringBuilder()
    for (index: Int in 0 until this.size) {
        if (index == 4){
            break
        }
        stringBuilder.append(this[index])
        if(index != this.size-1)
            stringBuilder.append(" · ")
    }
    return stringBuilder.toString()
}