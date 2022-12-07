package com.hadi.maydapp.data.repository

import com.hadi.maydapp.data.localmodels.ShortenedUrlDBModel
import com.hadi.maydapp.data.models.ShortenedUrlDataModel

interface UrlDataSource {

    suspend fun saveShortenedUrl(shortenedUrlDataModel: ShortenedUrlDataModel)

    suspend fun getAllShortenedUrl(): List<ShortenedUrlDataModel>
}