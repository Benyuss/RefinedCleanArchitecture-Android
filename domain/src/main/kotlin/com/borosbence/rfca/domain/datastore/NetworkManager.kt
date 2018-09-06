package com.borosbence.rfca.domain.datastore


interface NetworkManager {

    /**
     * Checks if the device is connected to the internet and has a healthy connection or not.
     */
    fun isConnectionAvailable(): Boolean
}