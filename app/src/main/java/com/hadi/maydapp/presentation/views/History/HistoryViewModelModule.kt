package com.hadi.maydapp.presentation.views.Home

import androidx.lifecycle.ViewModel
import com.hadi.maydapp.presentation.viewmodels.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HistoryViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel::class)
    abstract fun bindsHistoryViewModel(historyViewModel: HistoryViewModel): ViewModel
}
