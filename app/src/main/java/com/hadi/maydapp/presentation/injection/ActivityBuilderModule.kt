package com.hadi.maydapp.presentation.injection


import com.hadi.maydapp.presentation.views.Home.HomeActivity
import com.hadi.maydapp.presentation.views.Home.HomeViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [HomeViewModelModule::class])
    internal abstract fun bindsHomeActivity(): HomeActivity

//    @ContributesAndroidInjector
//    internal abstract fun bindsMainActivity(): MainActivity
}
