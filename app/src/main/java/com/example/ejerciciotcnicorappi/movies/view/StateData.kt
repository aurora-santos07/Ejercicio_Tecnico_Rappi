package com.example.ejerciciotcnicorappi.movies.view

sealed class StateData {
    object Loading: StateData()
    data class Success(var data: Any): StateData() {inline fun <reified T> responseTo() = data as T}
    data class Error(val error: Throwable): StateData() {inline fun <reified T> errotTo() = error as T}
}