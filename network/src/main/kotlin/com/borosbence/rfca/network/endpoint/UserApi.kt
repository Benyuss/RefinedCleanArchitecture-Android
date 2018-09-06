package com.borosbence.rfca.network.endpoint

import com.borosbence.rfca.network.model.UserWrapperResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * End point's to user rest api
 */
interface UserApi {

    @GET("api/")
    fun getUsers(@Query("results") count: Int): Observable<UserWrapperResponse>
}