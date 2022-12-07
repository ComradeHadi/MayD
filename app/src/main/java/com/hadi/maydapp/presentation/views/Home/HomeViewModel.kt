package com.hadi.maydapp.presentation.views.Home

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.hadi.maydapp.data.models.ShortenedUrlDataModel
import com.hadi.maydapp.domain.usecases.GetShortenedUrlUseCase
import com.hadi.maydapp.domain.usecases.UseCases
import com.hadi.maydapp.presentation.mapper.RateMapper
import com.hadi.maydapp.presentation.models.LinkUIModel
import com.hadi.maydapp.presentation.utils.ViewState
import com.hadi.maydapp.presentation.viewmodels.BaseSchedulerProvider
import com.hadi.maydapp.presentation.viewmodels.BaseViewModel
import io.reactivex.functions.Consumer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getAllUrlUseCase: GetShortenedUrlUseCase,
    private val rateMapper: RateMapper,
    baseSchedulerProvider: BaseSchedulerProvider
) :  BaseViewModel(baseSchedulerProvider = baseSchedulerProvider),LifecycleObserver {

    val amount = MutableLiveData<Int>()
   // val context: Application = Application()
    val savedLinks = MutableLiveData<List<ShortenedUrlDataModel>>()
    val serverShortenedUrl = MutableLiveData<ViewState<LinkUIModel>>()
    val coroutineScope = CoroutineScope(Dispatchers.IO)
//    @Inject
//    lateinit var localUrlReporistoy : LocalUrlReporistoy
    @Inject
    lateinit var useCases : UseCases

    fun getShortenedUrl(url: String) {
        execute(loadingConsumer = Consumer {
            serverShortenedUrl.postValue(ViewState.loading())
        }, throwableConsumer = Consumer {
            Log.e("111111111", it.toString())
            serverShortenedUrl.postValue(ViewState.error(it.message))
        }, successConsumer = Consumer {
            Log.e("111111111", it.toString())
            saveURL(it.toUrlModel())
            serverShortenedUrl.postValue(ViewState.success(
                rateMapper.mapDomainToPresentationModel(it)))
//            getURLS()
            checkIfThereAnySavedLinks()
        }, useCase = getAllUrlUseCase.getShortUrlRates(url))
    }

    fun saveURL(url: ShortenedUrlDataModel){
        coroutineScope.launch {
            useCases.saveShortenedUrlUseCase(url)
        }
    }

    fun getURLS(){
        coroutineScope.launch {
            Log.e("fg","Size ${useCases.getAllUrlsUseCase()}.size()}")
            useCases.getAllUrlsUseCase().forEachIndexed { index, item ->println(" xxxxxxxx $index  ${item.toString()}") }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun checkIfThereAnySavedLinks(){

        coroutineScope.launch {
            savedLinks.postValue(useCases.getAllUrlsUseCase())
            //savedLinks.value?.size
        }
    }




}


