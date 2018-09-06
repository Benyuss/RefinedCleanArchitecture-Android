package com.borosbence.rfca.data.datastore.core

import android.content.Context
import com.borosbence.rfca.domain.datastore.factory.DataStoreFactory

abstract class DataStoreFactoryBase<T>(context: Context) : DataStoreFactory<T>(
        NetworkManagerImpl(context)
)