package com.borosbence.rfca.api.repository

import io.reactivex.Observable

/**
 * Repositories grants access to DataStores.
 *
 * It's a tunnel between DataStores and Interactors.
 */
interface Repository<T> {

    /**
     * Get all available objects, wrapped into an Observable.
     */
    fun getAll(): Observable<List<T>>
}