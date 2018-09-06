package com.borosbence.rfca.data.repository

import android.content.Context
import com.borosbence.rfca.data.datastore.factory.UserDataStoreFactory
import com.borosbence.rfca.domain.datastore.UserDataStore
import com.borosbence.rfca.domain.model.User
import com.borosbence.rfca.domain.repository.UserRepository
import io.reactivex.Observable

class UserRepositoryImpl(context: Context) : UserRepository {

    private val userDataStore: UserDataStore = UserDataStoreFactory(context).getDataStore() as UserDataStore

    override fun getAll(): Observable<List<User>> {
        return userDataStore.getAll()
    }
}
