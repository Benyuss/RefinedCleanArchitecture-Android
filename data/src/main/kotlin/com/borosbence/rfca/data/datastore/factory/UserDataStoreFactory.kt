package com.borosbence.rfca.data.datastore.factory

import android.content.Context
import com.borosbence.rfca.api.datastore.DataStore
import com.borosbence.rfca.data.datastore.cloud.UserCloudDataStore
import com.borosbence.rfca.data.datastore.core.DataStoreFactoryBase
import com.borosbence.rfca.domain.model.User

class UserDataStoreFactory(context: Context) : DataStoreFactoryBase<User>(context) {

    override fun createCloudDataStore(): DataStore<User> {
        return UserCloudDataStore()
    }
}