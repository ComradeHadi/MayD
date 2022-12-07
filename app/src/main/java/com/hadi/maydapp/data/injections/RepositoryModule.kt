package com.hadi.maydapp.data.injections

import android.app.Application
import com.hadi.maydapp.data.mappers.DataLayerLinksesMapper
import com.hadi.maydapp.data.datasource.remotedatasource.ServiceApi
import com.hadi.maydapp.data.localmodels.RoomUrlDataSource
import com.hadi.maydapp.data.repository.LocalUrlReporistoy
import com.hadi.maydapp.data.repository.RepositoryImplementer
import com.hadi.maydapp.domain.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesDataLayerLinksMapper() = DataLayerLinksesMapper()

    @Singleton
    @Provides
    fun providesLinksRepository(serviceApi: ServiceApi, dataLayerLinksesMapper: DataLayerLinksesMapper): Repository {
        return RepositoryImplementer(serviceApi = serviceApi, dataLayerLinksesMapper = dataLayerLinksesMapper)
    }

    @Singleton
    @Provides
    fun providesUrlDBRepository(app: Application) = LocalUrlReporistoy(RoomUrlDataSource(app))



}
