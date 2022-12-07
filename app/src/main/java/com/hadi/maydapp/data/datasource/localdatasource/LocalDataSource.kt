package com.hadi.maydapp.data.datasource.remotedatasource

import com.hadi.maydapp.data.models.ShortenedUrlDataModel
import com.hadi.maydapp.domain.entities.ShortenedUrlEntity

interface LocalDataSource {
    suspend fun getAllLocalUrls(): List<ShortenedUrlDataModel>
    suspend fun add(shortenedUrlDataModel: ShortenedUrlEntity)

}
