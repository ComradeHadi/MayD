package com.hadi.maydapp.data.repository

import com.hadi.maydapp.data.datasource.remotedatasource.LocalDataSource
import com.hadi.maydapp.data.models.ShortenedUrlDataModel
import com.hadi.maydapp.domain.entities.ShortenedUrlEntity
import javax.inject.Inject

class LocalUrlReporistoy(
    private val dataSource: UrlDataSource
    ){

   suspend fun getAllLocalUrls() = dataSource.getAllShortenedUrl()

   suspend fun saveShortenedUrl(shortenedUrlDataModel: ShortenedUrlDataModel) = dataSource.saveShortenedUrl(shortenedUrlDataModel)

}