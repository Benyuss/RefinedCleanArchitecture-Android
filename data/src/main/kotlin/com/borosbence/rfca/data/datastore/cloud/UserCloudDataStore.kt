package com.borosbence.rfca.data.datastore.cloud

import com.borosbence.rfca.api.datastore.subtypes.CloudDataStore
import com.borosbence.rfca.data.core.Constants
import com.borosbence.rfca.data.mapper.UserResponseMapper
import com.borosbence.rfca.domain.datastore.UserDataStore
import com.borosbence.rfca.domain.model.User
import com.borosbence.rfca.network.controller.UserController
import io.reactivex.Observable

/**
 * It hides the Controller behind a nice generic interface
 */
class UserCloudDataStore : UserDataStore, CloudDataStore<User> {

    override fun getAll(): Observable<List<User>> {
        return UserController().getUsers(Constants.USER_COUNT_TO_DOWNLOAD).map { userWrapper ->
            UserResponseMapper().mapFromList(userWrapper.users)
        }
    }
}