package com.borosbence.rfca.api.datastore.subtypes

import com.borosbence.rfca.api.datastore.DataStore

/**
 * This is a sub-type of [DataStore].
 *
 * You should put a server data source behind it (Like a rest api).
 */
interface CloudDataStore<T> : DataStore<T>