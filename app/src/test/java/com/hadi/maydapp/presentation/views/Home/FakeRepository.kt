package com.hadi.maydapp.presentation.views.Home

import com.hadi.maydapp.data.repository.StubServiceApi
import com.hadi.maydapp.domain.Repository
import com.hadi.maydapp.domain.entities.ShortenedUrlEntity
import io.reactivex.Single

class FakeRepository : Repository {
    private val stub = StubServiceApi()
    override fun getShortUrl(url: String): Single<ShortenedUrlEntity> {
        TODO("Not yet implemented")
    }


}
