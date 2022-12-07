package com.hadi.maydapp.data.datasource.remotedatasource

import com.hadi.maydapp.data.models.ShortenedUrlResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {
    @GET("shorten")
    fun getShortenedUrlFromServer(@Query("url") url: String): Single<ShortenedUrlResponse>

}
