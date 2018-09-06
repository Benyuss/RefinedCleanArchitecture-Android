package com.borosbence.rfca.presentation.users.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.borosbence.rfca.domain.interactor.GetUsers
import com.borosbence.rfca.presentation.mapper.UserToUserModelMapper

class UserVMFactory(private val interactor: GetUsers,
                    private val mapper: UserToUserModelMapper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(interactor, mapper) as T
    }
}