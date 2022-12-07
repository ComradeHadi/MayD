package com.hadi.maydapp.domain.usecases

import com.hadi.maydapp.data.repository.LocalUrlReporistoy

class GetAllUrlsUseCase constructor(
    private val localUrlReporistoy: LocalUrlReporistoy
) {
    suspend operator fun invoke() = localUrlReporistoy.getAllLocalUrls()
}
