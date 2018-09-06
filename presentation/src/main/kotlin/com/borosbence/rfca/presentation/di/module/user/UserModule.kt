package com.borosbence.rfca.presentation.di.module.user

import com.borosbence.rfca.domain.interactor.GetUsers
import com.borosbence.rfca.domain.repository.UserRepository
import com.borosbence.rfca.presentation.mapper.UserToUserModelMapper
import com.borosbence.rfca.presentation.users.vm.UserVMFactory
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun provideGetUsers(userRepository: UserRepository): GetUsers {
        return GetUsers(userRepository)
    }

    @Provides
    fun provideUserVMFactory(getUsers: GetUsers, mapper: UserToUserModelMapper): UserVMFactory {
        return UserVMFactory(getUsers, mapper)
    }
}