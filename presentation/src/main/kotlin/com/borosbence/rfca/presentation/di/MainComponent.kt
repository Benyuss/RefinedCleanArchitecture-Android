package com.borosbence.rfca.presentation.di

import com.borosbence.rfca.presentation.di.module.AppModule
import com.borosbence.rfca.presentation.di.module.DataModule
import com.borosbence.rfca.presentation.di.module.user.UserModule
import com.borosbence.rfca.presentation.di.module.user.UserSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AppModule::class),
    (DataModule::class)])

interface MainComponent {
    fun plus(userModule: UserModule): UserSubComponent
}