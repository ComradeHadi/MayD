package com.hadi.maydapp.domain.usecases

import com.hadi.maydapp.data.models.ShortenedUrlDataModel
import com.hadi.maydapp.data.repository.LocalUrlReporistoy

class SaveShortenedUrlUseCase constructor(
    private val localUrlReporistoy: LocalUrlReporistoy
) {
    suspend operator fun invoke(shortenedUrlDataModel: ShortenedUrlDataModel) = localUrlReporistoy.saveShortenedUrl(shortenedUrlDataModel)

}
