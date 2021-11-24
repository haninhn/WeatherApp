package com.test.weatherapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

//constant object
object Constants {

    // Add the API key and Base URL and Metric unit here from openweathermap.)
    const val APP_ID: String = "8874dc92ec67e898711db294857bf7fa"
    const val BASE_URL: String = "http://api.openweathermap.org/data/"
    const val METRIC_UNIT: String = "metric"

    //    //  Add a function to check the network connection is available or not.) the internet
//     * This function is used check the weather the device is connected to the Internet or not.
    fun isNetworkAvailable(context: Context): Boolean {
        // It answers the queries about the state of network connectivity.
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager //connectivityManager 3tinaha il connectivity services of owner system
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //m is code version
            val network      = connectivityManager.activeNetwork ?: return false  //get the network if doesn't exist return false
            val activeNetWork = connectivityManager.getNetworkCapabilities(network) ?: return false //and then  check for network NetworkCapabilities
            return when { // if true return true kan w7da fihom active
                activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            // Returns details about the currently active default data network.
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnectedOrConnecting
        }
    }
}

