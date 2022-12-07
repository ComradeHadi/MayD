package com.hadi.maydapp.data.repository

import com.hadi.maydapp.data.mappers.DataLayerLinksesMapper
import io.reactivex.Single
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.Test


class RepositoryImplementerTest {
    private val serviceApi = StubServiceApi()
    private val dataLayerLinkMapper = DataLayerLinksesMapper()
    private val sut = RepositoryImplementer(serviceApi, dataLayerLinkMapper)


    @Test
    fun `get shortened url do return objects and not null`(){
        val serverShortenedUrl = rxValue(serviceApi.getShortenedUrlFromServer("https://www.youtube.com/watch?v=HW2A98153Oo&t=6758s"))
        val dummyShortenedUrl = rxValue(sut.getShortUrl("https://www.youtube.com/watch?v=HW2A98153Oo&t=6758s"))

        assertThat(serverShortenedUrl)
            .isNotNull()

        assertThat(dummyShortenedUrl)
            .isNotNull()

    }

    private fun <T> rxValue(dataLayerModelItem: Single<T>) : T = dataLayerModelItem.test().values().get(0)
}

