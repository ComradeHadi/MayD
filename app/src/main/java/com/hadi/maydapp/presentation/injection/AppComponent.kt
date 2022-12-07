package com.hadi.maydapp.presentation.injection

import android.app.Application
import com.hadi.maydapp.data.injections.RepositoryModule
import com.hadi.maydapp.data.injections.RetrofitModule
import com.hadi.maydapp.domain.UseCasesModule
import com.hadi.maydapp.presentation.MayD
import com.hadi.maydapp.presentation.viewmodels.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelFactory::class,
        ActivityBuilderModule::class,
        RetrofitModule::class,
        RepositoryModule::class,
        UseCasesModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<MayD> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
