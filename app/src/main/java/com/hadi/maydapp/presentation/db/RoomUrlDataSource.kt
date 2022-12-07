package com.hadi.maydapp.presentation.db

import android.content.Context
import com.hadi.maydapp.data.datasource.remotedatasource.LocalDataSource
import com.hadi.maydapp.data.models.ShortenedUrlDataModel
import com.hadi.maydapp.domain.entities.ShortenedUrlEntity

class RoomUrlDataSource (context: Context) : LocalDataSource{
    val urlDao = DatabseService.getInstance(context).urlDao()
    override suspend fun getAllLocalUrls(): List<ShortenedUrlDataModel> = urlDao.getAllUrl().map { it.toUrlModel() }

    override suspend fun add(shortenedUrlDataModel: ShortenedUrlEntity)  = urlDao.insertUrl(ShortenedUrlEntity.fromUrlModel(shortenedUrlDataModel.toUrlModel()))
}