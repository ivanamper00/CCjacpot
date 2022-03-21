package com.giaidac.common.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.giaidac.common.base.SingleLiveEvent
import com.giaidac.common.event.UiEvent

class ActivityViewModel: ViewModel() {

    private val _uiEvent = SingleLiveEvent<UiEvent>()
    val activityEvent: LiveData<UiEvent> get() = _uiEvent

    fun SplashDone() {
//        _uiEvent.value = ActivityEvent.SplashDone
    }

    fun toProcedure() {
        _uiEvent.value = ActivityEvent.ProcedurePage
    }
}