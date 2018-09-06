package com.borosbence.rfca.presentation.core

import android.app.Application
import com.borosbence.rfca.presentation.di.DaggerMainComponent
import com.borosbence.rfca.presentation.di.MainComponent
import com.borosbence.rfca.presentation.di.module.AppModule
import com.borosbence.rfca.presentation.di.module.DataModule
import com.borosbence.rfca.presentation.di.module.user.UserModule
import com.borosbence.rfca.presentation.di.module.user.UserSubComponent
import com.jakewharton.threetenabp.AndroidThreeTen

/**
 * Custom application class to make the global initializations on application startup.
 */
class CleanApplication : Application() {

    private lateinit var mainComponent: MainComponent
    private var userComponent: UserSubComponent? = null

    override fun onCreate() {
        super.onCreate()

        initThreeTen()
        initDependencies()
    }

    private fun initThreeTen() {
        AndroidThreeTen.init(this)
    }

    private fun initDependencies() {
        mainComponent = DaggerMainComponent.builder()
                .appModule(AppModule(this, applicationContext))
                .dataModule(DataModule())
                .build()
    }

    fun createUserComponent(): UserSubComponent {
        userComponent = mainComponent.plus(UserModule())
        return userComponent!!
    }
}