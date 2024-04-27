package com.example.taskdive.domain.usecases

sealed class State<T> {
    class Error<T>(message: String?) : State<T>()

    class Success<T>(data: T? = null) : State<T>()

    class Loading<T> : State<T>()

    class Empty<T> : State<T>()
}