package com.hadi.maydapp.domain.entities

import com.hadi.maydapp.data.repository.StubServiceApi
import org.junit.Assert
import org.junit.Test

class ShortenedUrlEntityTest {
    private val stubServiceApi = StubServiceApi()
    val fakeUrlDomainEntity = stubServiceApi.getDomainUrlEntity()



    @Test
    fun toConfirmCreationOfRepoModel() {
        Assert.assertNotNull(fakeUrlDomainEntity)

    }

    @Test
    fun confirmCode() {
        Assert.assertEquals(fakeUrlDomainEntity.code, "DrpLId")

    }


    @Test
    fun getShortLink() {
        Assert.assertEquals(fakeUrlDomainEntity.short_link, "shrtco.de/DrpLId")
    }

    @Test
    fun getFullShortLink() {
        Assert.assertEquals(fakeUrlDomainEntity.full_short_link, "https://shrtco.de/DrpLId")
    }

    @Test
    fun getOriginalLink() {
        Assert.assertEquals(fakeUrlDomainEntity.original_link, "https://www.youtube.com/watch?v=HW2A98153Oo&t=6758s")
    }

    @Test
    fun getId() {
        Assert.assertEquals(fakeUrlDomainEntity.id, 0L)

    }
}
