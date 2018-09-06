package com.borosbence.rfca.domain.datastore

import com.borosbence.rfca.api.datastore.DataStore
import com.borosbence.rfca.domain.model.User

/**
 * DataStore to get [User] data.
 *
 * If you want to have any specific CRUD methods, you should define these here.
 */
interface UserDataStore : DataStore<User>