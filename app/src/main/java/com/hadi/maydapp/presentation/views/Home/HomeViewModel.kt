package com.hadi.maydapp.presentation.views.Home

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.hadi.maydapp.data.models.ShortenedUrlDataModel
import com.hadi.maydapp.domain.usecases.GetShortenedUrlUseCase
import com.hadi.maydapp.domain.usecases.UseCasesHolder
import com.hadi.maydapp.presentation.mapper.LinkMapper
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
    private val linkMapper: LinkMapper,
    baseSchedulerProvider: BaseSchedulerProvider
) :  BaseViewModel(baseSchedulerProvider = baseSchedulerProvider),LifecycleObserver {

    val savedLinks = MutableLiveData<List<ShortenedUrlDataModel>>()
    val serverShortenedUrl = MutableLiveData<ViewState<LinkUIModel>>()
    val isThereAnySavedLink = MutableLiveData<Boolean>()
    val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCasesHolder : UseCasesHolder

    fun getShortenedUrl(url: String) {
        execute(loadingConsumer = Consumer {
            serverShortenedUrl.postValue(ViewState.loading())
        }, throwableConsumer = Consumer {
            Log.e("111111111", it.toString())
            serverShortenedUrl.postValue(ViewState.error(it.message))
        }, successConsumer = Consumer {
            Log.e("1111 success", it.toString())
            saveURL(it.toUrlModel())
            serverShortenedUrl.postValue(ViewState.success(
                linkMapper.mapDomainToPresentationModel(it)))
//            getURLS()
            checkIfThereAnySavedLinks()
        }, useCase = getAllUrlUseCase.getShortUrlRates(url))
    }

    fun saveURL(url: ShortenedUrlDataModel){
        coroutineScope.launch {
            useCasesHolder.saveShortenedUrlUseCase(url)
            isThereAnySavedLink.postValue(true)

        }
    }

    fun getURLS(){
        coroutineScope.launch {
            Log.e("fg","Size ${useCasesHolder.getAllUrlsUseCase()}.size()}")
            useCasesHolder.getAllUrlsUseCase().forEachIndexed { index, item ->println(" xxxxxxxx $index  ${item.toString()}") }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun checkIfThereAnySavedLinks(){

        coroutineScope.launch {
            savedLinks.postValue(useCasesHolder.getAllUrlsUseCase())
        }
    }




}


