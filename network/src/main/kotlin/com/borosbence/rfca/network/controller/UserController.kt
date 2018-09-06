package com.borosbence.rfca.network.controller

import com.borosbence.rfca.network.core.ApiClient
import com.borosbence.rfca.network.core.HttpClientFactory
import com.borosbence.rfca.network.endpoint.UserApi
import com.borosbence.rfca.network.model.UserWrapperResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * You can call the [UserApi] endPoints from here and create a http transaction.
 *
 * Should wrapped behind a DataStore
 */
class UserController {

    fun getUsers(userCount: Int): Observable<UserWrapperResponse> {
        val api: UserApi = ApiClient.getClient(HttpClientFactory.getClient()).create(UserApi::class.java)

        return api
                .getUsers(userCount)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}