package com.hadi.maydapp.domain

import com.hadi.maydapp.domain.entities.ShortenedUrlEntity
import io.reactivex.Single

interface Repository {
    fun getShortUrl(url: String): Single<ShortenedUrlEntity>
}
