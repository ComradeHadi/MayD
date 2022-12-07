package com.hadi.maydapp.presentation.injection


import com.hadi.maydapp.presentation.mapper.LinkMapper
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
    fun providesRatesMapper() = LinkMapper()

//    @Provides
//    fun providesApp() = Application()
}
