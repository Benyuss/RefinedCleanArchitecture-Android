package com.borosbence.rfca.domain.datastore.factory

import com.borosbence.rfca.api.datastore.DataStore
import com.borosbence.rfca.domain.datastore.NetworkManager
import com.borosbence.rfca.domain.exception.IllegalDataStoreStateException

/**
 * This factory has a very major role.
 *
 * It decides which [DataStore] is the best for the actual request then creates an instance of it.
 */
abstract class DataStoreFactory<T>(private var networkManager: NetworkManager) {

    fun getDataStore(): DataStore<T> {
        when {
            networkManager.isConnectionAvailable() -> return createCloudDataStore()
            else -> throw IllegalDataStoreStateException()
        }
    }

    abstract fun createCloudDataStore(): DataStore<T>
}