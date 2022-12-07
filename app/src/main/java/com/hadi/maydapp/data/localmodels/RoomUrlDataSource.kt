package com.hadi.maydapp.data.localmodels

import android.content.Context
import com.hadi.maydapp.data.models.ShortenedUrlDataModel
import com.hadi.maydapp.data.repository.UrlDataSource

class RoomUrlDataSource (context: Context): UrlDataSource {
    val urlDAO = DatabaseService.getInstance(context).urlDao()
    override suspend fun saveShortenedUrl(shortenedUrlDataModel: ShortenedUrlDataModel)  = urlDAO.saveUrl(ShortenedUrlDBModel.fromRemoteUrlModel(shortenedUrlDataModel))

    override suspend fun getAllShortenedUrl() = urlDAO.getAllLocalUrls().map { it.toRemoteUrlModel() }
}