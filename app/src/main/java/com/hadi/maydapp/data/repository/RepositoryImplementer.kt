package com.hadi.maydapp.data.repository

import com.hadi.maydapp.data.mappers.DataLayerRatesMapper
import com.hadi.maydapp.data.datasource.remotedatasource.ServiceApi
import com.hadi.maydapp.domain.Repository
import com.hadi.maydapp.domain.entities.ShortenedUrlEntity
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImplementer @Inject constructor(
    private val serviceApi: ServiceApi,
    private val dataLayerRatesMapper: DataLayerRatesMapper
) : Repository {
    override fun getShortUrl(url: String): Single<ShortenedUrlEntity> {
        return serviceApi.getAllRates(url).map{ rateModelResponse -> dataLayerRatesMapper.mapDataToDomainModel(rateModelResponse.result)}

    }

//    override suspend fun getAllShortUrls() = localDataSource.getAllLocalUrls()
//
//    override suspend fun saveAllShortUrl(shortenedUrlDataModel: ShortenedUrlDataModel) = localDataSource.add(shortenedUrlDataModel)

}
