package com.borosbence.rfca.network.model

import com.squareup.moshi.Json

class ProfilePictureResponse(
        @Json(name = "large")
        var picture: String?
)