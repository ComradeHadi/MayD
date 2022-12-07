package com.hadi.maydapp.presentation.models

import com.hadi.maydapp.data.repository.StubServiceApi
import org.junit.Assert
import org.junit.Test

class LinkUIModelTest {
    private val stubServiceApi = StubServiceApi()
    val fakeUrlDataModel = stubServiceApi.getLinkModelUI()



    @Test
    fun toConfirmCreationOfRepoModel() {
        Assert.assertNotNull(fakeUrlDataModel)

    }

    @Test
    fun confirmCode() {
        Assert.assertEquals(fakeUrlDataModel.code, "DrpLId")

    }


    @Test
    fun getShortLink() {
        Assert.assertEquals(fakeUrlDataModel.short_link, "shrtco.de/DrpLId")
    }

    @Test
    fun getFullShortLink() {
        Assert.assertEquals(fakeUrlDataModel.full_short_link, "https://shrtco.de/DrpLId")
    }

    @Test
    fun getOriginalLink() {
        Assert.assertEquals(fakeUrlDataModel.original_link, "https://www.youtube.com/watch?v=HW2A98153Oo&t=6758s")
    }


}
