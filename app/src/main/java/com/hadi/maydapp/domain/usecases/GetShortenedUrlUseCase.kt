package com.hadi.maydapp.domain.usecases

import com.hadi.maydapp.data.models.ShortenedUrlDataModel
import com.hadi.maydapp.domain.Repository
import javax.inject.Inject

class GetShortenedUrlUseCase @Inject constructor(
    private val repository: Repository
) {
    fun getShortUrlRates(url: String) = repository.getShortUrl(url)
}
