package com.borosbence.rfca.network.model

import com.squareup.moshi.Json

class UserWrapperResponse(
        @Json(name = "results")
        var users: List<UserResponse>
)