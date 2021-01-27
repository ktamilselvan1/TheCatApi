package com.tamil.catimagepicker.base

internal sealed class ViewState<out T : Any>
internal class Success<out T : Any>(val data: T) : ViewState<T>()
internal class Error<out T : Any>(val error: Throwable) : ViewState<T>()
internal class Loading<out T : Any> : ViewState<T>()
internal class NoInternetState<T : Any> : ViewState<T>()
