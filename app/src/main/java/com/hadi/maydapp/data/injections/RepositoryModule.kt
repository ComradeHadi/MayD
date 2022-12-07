package com.hadi.maydapp.data.injections

import android.app.Application
import com.hadi.maydapp.data.datasource.remotedatasource.LocalDataSource
import com.hadi.maydapp.data.mappers.DataLayerRatesMapper
import com.hadi.maydapp.data.datasource.remotedatasource.ServiceApi
import com.hadi.maydapp.data.localmodels.RoomUrlDataSource
import com.hadi.maydapp.data.repository.LocalUrlReporistoy
import com.hadi.maydapp.data.repository.RepositoryImplementer
import com.hadi.maydapp.data.repository.UrlDataSource
import com.hadi.maydapp.domain.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesDataLayerRatesMapper() = DataLayerRatesMapper()
//
//    @Singleton
//    @Provides
//    fun providesDataSource()  =  LocalDataSource

    @Singleton
    @Provides
    fun providesRatesRepository(serviceApi: ServiceApi, dataLayerRatesMapper: DataLayerRatesMapper): Repository {
        return RepositoryImplementer(serviceApi = serviceApi, dataLayerRatesMapper = dataLayerRatesMapper)
    }

    @Singleton
    @Provides
    fun providesUrlDBRepository(app: Application) = LocalUrlReporistoy(RoomUrlDataSource(app))



}
