package com.hadi.maydapp.presentation.views.Home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.hadi.maydapp.data.repository.StubServiceApi
import com.hadi.maydapp.domain.usecases.GetShortenedUrlUseCase
import com.hadi.maydapp.presentation.mapper.LinkMapper
import com.hadi.maydapp.presentation.models.LinkUIModel
import com.hadi.maydapp.presentation.utils.ViewState
import com.hadi.maydapp.presentation.viewmodels.BaseSchedulerProvider
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)

class HomeViewModelTest {

    @Mock
    private lateinit var homeViewModel: HomeViewModel

    @Mock
    private lateinit var repository: FakeRepository


    private lateinit var getShortenedUrlUseCase: GetShortenedUrlUseCase

    @Mock
    private lateinit var dataLayerLinksesMapper: LinkMapper

    @Mock
    private lateinit var baseSchedulerProvider: BaseSchedulerProvider

    @Mock
    private lateinit var shortenedUrlLiveData: LiveData<ViewState<LinkUIModel>>

    @Mock
    private lateinit var observer: Observer<in ViewState<LinkUIModel>>

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()



    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)

        getShortenedUrlUseCase = GetShortenedUrlUseCase(repository)

        homeViewModel =
            Mockito.spy(HomeViewModel(getShortenedUrlUseCase, dataLayerLinksesMapper, baseSchedulerProvider))
        shortenedUrlLiveData = homeViewModel.serverShortenedUrl

    }

    @Test
    fun `verify presence of mutable live data changeablity`() {
        Assert.assertNotNull(homeViewModel.serverShortenedUrl)

    }



    @Test
    fun`confirming if live data value is been set and accessible in view model`(){

        val stub = StubServiceApi()
        val urlEntity = stub.getDomainUrlEntity()

        val valueToSet = ViewState.success(dataLayerLinksesMapper.mapDomainToPresentationModel(
            urlEntity))


        homeViewModel.serverShortenedUrl.postValue(valueToSet)

        assertNotNull(shortenedUrlLiveData)
        assertEquals(homeViewModel.serverShortenedUrl.value, valueToSet)


    }

}
