package com.example.ejerciciotcnicorappi.movies.view.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

val Context.isConnected: Boolean
    get() {
        val connecctivityManager  = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return when{
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ->{
                val network = connecctivityManager.activeNetwork?: return false
                val activityNetwork = connecctivityManager.getNetworkCapabilities(network)?: return false
                when{
                    activityNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)-> true
                    activityNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)-> true
                    else -> false
                }
            }else -> {
                val networkInfo = connecctivityManager.activeNetworkInfo?: return false
                networkInfo.isConnected
            }
        }
    }