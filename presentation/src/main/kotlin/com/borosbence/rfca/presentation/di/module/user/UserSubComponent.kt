package com.borosbence.rfca.presentation.di.module.user

import com.borosbence.rfca.presentation.users.presenter.UserPresenterImpl
import dagger.Subcomponent

@UserScope
@Subcomponent(modules = [
    UserModule::class
])
interface UserSubComponent {

    fun inject(userPresenterImpl: UserPresenterImpl)
}