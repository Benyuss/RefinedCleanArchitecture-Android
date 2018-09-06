package com.borosbence.rfca.presentation.di.module

import android.content.Context
import com.borosbence.rfca.data.repository.UserRepositoryImpl
import com.borosbence.rfca.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideUserRepository(context: Context): UserRepository {
        return UserRepositoryImpl(context)
    }
}