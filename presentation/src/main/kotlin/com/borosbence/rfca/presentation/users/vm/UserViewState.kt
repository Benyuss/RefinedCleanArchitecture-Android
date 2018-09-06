package com.borosbence.rfca.presentation.users.vm

import com.borosbence.rfca.presentation.model.UserModel

/**
 * This data class holds the state of the [com.borosbence.rfca.presentation.users.view.UserView]
 */
data class UserViewState(
        var showLoading: Boolean = true,
        var users: List<UserModel>? = null
)