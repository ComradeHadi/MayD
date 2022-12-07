package com.hadi.maydapp.presentation


import com.hadi.maydapp.presentation.injection.AppComponent
import com.hadi.maydapp.presentation.injection.DaggerAppComponent
import dagger.android.DaggerApplication

class MayD: DaggerApplication() {
    override fun applicationInjector(): AppComponent {
        return DaggerAppComponent.builder().application(this).build()
    }
}
