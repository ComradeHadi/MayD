package com.hadi.maydapp.data.mappers

import com.hadi.maydapp.data.models.ShortenedUrlDataModel
import com.hadi.maydapp.domain.entities.ShortenedUrlEntity
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DataLayerLinksMapperTest{

    @RelaxedMockK
    lateinit var dataLayerLinksMapper: DataLayerLinksesMapper

    @RelaxedMockK
    lateinit var anyLink: ShortenedUrlDataModel


    @Before
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun `verify is mapping from repo model to domain layer team entity is done right`(){
        val expected = dataLayerLinksMapper.mapDataToDomainModel(anyLink)

        Assert.assertNotNull(expected)
        Assert.assertTrue(expected is ShortenedUrlEntity)
        Assert.assertTrue(expected.code == "")
    }
}
