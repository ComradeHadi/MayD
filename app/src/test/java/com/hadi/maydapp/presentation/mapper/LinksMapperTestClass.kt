package com.hadi.maydapp.presentation.mapper

import com.hadi.maydapp.data.mappers.DataLayerLinksesMapper
import com.hadi.maydapp.data.models.ShortenedUrlDataModel
import com.hadi.maydapp.domain.entities.ShortenedUrlEntity
import com.hadi.maydapp.presentation.models.LinkUIModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LinksMapperTestClass{

    @RelaxedMockK
    lateinit var dataLayerLinksMapper: LinkMapper

    @RelaxedMockK
    lateinit var anyLink: ShortenedUrlEntity


    @Before
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun `verify is mapping from repo model to domain layer team entity is done right`(){
        val expected = dataLayerLinksMapper.mapDomainToPresentationModel(anyLink)

        Assert.assertNotNull(expected)
        Assert.assertTrue(expected is LinkUIModel)
        Assert.assertTrue(expected.code == "")
    }
}
