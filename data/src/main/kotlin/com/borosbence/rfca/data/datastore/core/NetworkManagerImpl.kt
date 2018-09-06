package com.borosbence.rfca.data.datastore.core

import android.content.Context
import android.net.ConnectivityManager
import com.borosbence.rfca.domain.datastore.NetworkManager

class NetworkManagerImpl(private var context: Context) : NetworkManager {

    /**
     * Checks if the device is connected to the internet and has a healthy connection or not.
     */
    override fun isConnectionAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}