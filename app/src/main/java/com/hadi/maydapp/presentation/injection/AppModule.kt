package com.hadi.maydapp.presentation.injection


import android.app.Application
import com.hadi.maydapp.presentation.mapper.RateMapper
import com.hadi.maydapp.presentation.viewmodels.BaseSchedulerProvider
import com.hadi.maydapp.presentation.viewmodels.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun providesTaskBaseScheduler(): BaseSchedulerProvider =
        SchedulerProvider()

    @Singleton
    @Provides
    fun providesRatesMapper() = RateMapper()

//    @Provides
//    fun providesApp() = Application()
}
