package com.giaidac.common.ui

import com.giaidac.common.event.UiEvent

sealed class ActivityEvent: UiEvent() {
    object ProcedurePage: UiEvent()
}