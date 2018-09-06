package com.borosbence.rfca.api.datastore

import io.reactivex.Observable

/**
 * Data stores are Data sources.
 * It could be a database, a remote server, a file, anything..
 *
 * You should hide these resources behind a DataStore type like CloudDataStore, LocalDataStore, FileDataStore, etc...
 * It provides extreme dynamics and you can easily swap any data source with little modifications.
 */
interface DataStore<T> {

    /**
     * Get all available objects, wrapped into an Observable.
     */
    fun getAll(): Observable<List<T>>
}