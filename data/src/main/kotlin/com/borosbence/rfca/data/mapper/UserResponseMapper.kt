package com.borosbence.rfca.data.mapper

import com.borosbence.rfca.api.mapper.Mapper
import com.borosbence.rfca.domain.model.User
import com.borosbence.rfca.network.model.UserResponse

class UserResponseMapper : Mapper<UserResponse, User>() {

    override fun mapFrom(from: UserResponse): User {
        return User(
                from.name.first ?: "",
                from.name.last ?: "",
                from.email ?: "",
                from.picture.picture ?: ""
        )
    }
}