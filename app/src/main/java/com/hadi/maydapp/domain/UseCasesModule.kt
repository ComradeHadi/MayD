package com.hadi.maydapp.domain

import com.hadi.maydapp.data.injections.RepositoryModule
import com.hadi.maydapp.data.repository.LocalUrlReporistoy
import com.hadi.maydapp.domain.usecases.GetAllUrlsUseCase
import com.hadi.maydapp.domain.usecases.GetShortenedUrlUseCase
import com.hadi.maydapp.domain.usecases.SaveShortenedUrlUseCase
import com.hadi.maydapp.domain.usecases.UseCases
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RepositoryModule::class])
class UseCasesModule {

    @Singleton
    @Provides
    fun provideShortenedUseCase(repository: Repository) = GetShortenedUrlUseCase(repository = repository)

//    @Singleton
//    @Provides
//    fun provideUrlUseCase(localDataSource: LocalDataSource) = GetAllUrlsUseCase(localDataSource = localDataSource)

    @Singleton
    @Provides
    fun getUseCases(localUrlRepo: LocalUrlReporistoy) =
        UseCases(
            GetAllUrlsUseCase(localUrlRepo),
            SaveShortenedUrlUseCase(localUrlRepo)

        )
}
