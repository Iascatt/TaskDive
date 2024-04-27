package com.example.taskdive.domain.usecases.filter

import com.example.taskdive.data.repository.DiveRepository
import com.example.taskdive.domain.models.Tag
import com.example.taskdive.domain.usecases.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FilterUseCase(
    private val repository: DiveRepository
) {
    fun getTags(): Flow<State<List<Tag>>> = flow {
        try {
            emit(State.Loading())

            val tags = repository.getAllTags()

            if (tags.isNullOrEmpty()) {
                emit(State.Empty())
            } else {
                emit(State.Success(tags))
            }
        } catch (e: Exception) {
            emit(State.Error(e.localizedMessage))
        }
    }

    fun addTag() {

    }
}