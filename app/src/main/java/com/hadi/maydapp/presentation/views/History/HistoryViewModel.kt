package com.hadi.maydapp.presentation.views.Home

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.hadi.maydapp.domain.usecases.GetShortenedUrlUseCase
import com.hadi.maydapp.presentation.mapper.RateMapper
import com.hadi.maydapp.presentation.models.LinkUIModel
import com.hadi.maydapp.presentation.utils.ViewState
import com.hadi.maydapp.presentation.viewmodels.BaseSchedulerProvider
import com.hadi.maydapp.presentation.viewmodels.BaseViewModel
import io.reactivex.functions.Consumer
import javax.inject.Inject

class HistoryViewModel @Inject constructor(
    private val getShortenedUrlUseCase: GetShortenedUrlUseCase,
    private val rateMapper: RateMapper,
    baseSchedulerProvider: BaseSchedulerProvider
) : BaseViewModel(baseSchedulerProvider = baseSchedulerProvider),LifecycleObserver {

    val amount = MutableLiveData<Int>()
    val amountToReceive = MutableLiveData<Int>()
    val allRates = MutableLiveData<ViewState<LinkUIModel>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun getShortenedUrl() {
        execute(loadingConsumer = Consumer {
            allRates.postValue(ViewState.loading())
        }, throwableConsumer = Consumer {
            allRates.postValue(ViewState.error(it.message))
        }, successConsumer = Consumer {
            Log.e("111111111", it.toString())
            allRates.postValue(ViewState.success(
                rateMapper.mapDomainToPresentationModel(it)))
        }, useCase = getShortenedUrlUseCase.getShortUrlRates("https://hub.qovery.com/guides/tutorial/url-shortener-api-with-kotlin/"))
    }

    private fun updateAmountLiveData(amountFigure: Int){
        amount.postValue(amountFigure)
    }

    private fun updateAmountToReceiveLiveData(amountToReceiveFigure: Int){
        amountToReceive.postValue(amountToReceiveFigure)
    }
}


