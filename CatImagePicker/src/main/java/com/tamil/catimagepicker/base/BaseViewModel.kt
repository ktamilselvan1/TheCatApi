package com.tamil.catimagepicker.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamil.data.utils.Connectivity
import kotlinx.coroutines.launch

internal abstract class BaseViewModel<T : Any> : ViewModel() {

    lateinit var connectivity: Connectivity

    protected val _viewState = MutableLiveData<ViewState<T>>()
    val viewState: LiveData<ViewState<T>>
        get() = _viewState

    protected fun executeUseCase(action: suspend () -> Unit) {
        _viewState.value = Loading()
        viewModelScope.launch { action() }
    }
}