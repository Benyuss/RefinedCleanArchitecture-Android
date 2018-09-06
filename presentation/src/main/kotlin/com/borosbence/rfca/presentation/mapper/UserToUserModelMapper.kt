package com.borosbence.rfca.presentation.mapper

import com.borosbence.rfca.api.mapper.Mapper
import com.borosbence.rfca.domain.model.User
import com.borosbence.rfca.presentation.model.UserModel
import javax.inject.Inject

/**
 * Maps [User] objects into [UserModel]s.
 */
class UserToUserModelMapper @Inject constructor() : Mapper<User, UserModel>() {

    override fun mapFrom(from: User): UserModel {
        return UserModel(
                "${from.firstName} ${from.lastName}",
                from.email,
                from.profilePicture
        )
    }
}