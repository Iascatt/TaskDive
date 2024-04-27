package com.example.taskdive.domain

sealed class State<T>(val data: T? = null, val message: String? = null) {
    class Error<T>(message: String?) : State<T>(data = null, message)

    class Success<T>(data: T? = null) : State<T>(data, message = null)

    class Loading<T> : State<T>()

    class Empty<T> : State<T>()
}