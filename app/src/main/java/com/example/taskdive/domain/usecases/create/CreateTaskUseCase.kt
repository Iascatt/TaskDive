package com.example.taskdive.domain.usecases.create

import com.example.taskdive.data.repository.DiveRepository
import com.example.taskdive.domain.State
import com.example.taskdive.domain.models.Status
import com.example.taskdive.domain.models.Task
import com.example.taskdive.domain.models.Weekday
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date

class CreateTaskUseCase(
    private val repository: DiveRepository
) {

    fun checkInput(){}
    fun createTask(
        title: String?,
        info: String?,
        startDate: Date?,
        finDate: Date?,
        repeatEveryDayOfWeek: Weekday? = null,
        repeatEveryDayOfMonth: Int? = null, //от 1 до 31
        repeatEveryDayOfYear: Int? = null, // от 1 до 366
        repeatThrough: Date? = null,
        importance: Int? = null,
        difficulty: Int? = null
    ): Flow<State<Unit>> = flow {
        try {
            emit(State.Loading())

            if (startDate != null && finDate != null) {
                if (startDate.time > finDate.time
                ) {
                    emit(State.Error(message = "Время начала больше времени окончания"))
                } else if (repeatEveryDayOfMonth !in 1..31) {
                    emit(State.Error(message = "Неправильное число месяца"))
                } else if (repeatEveryDayOfYear !in 1..366) {
                    emit(State.Error(message = "Неправильное число года"))
                }
            }
            else if (importance != null && importance !in 1..5) {
                emit(State.Error(message = "Неправильно указана важность"))
            } else if (difficulty != null && difficulty !in 1..5) {
                emit(State.Error(message = "Неправильно указана сложность"))
            }  else {
                repository.addTask(Task(
                    null,
                    title ?: "",
                    info,
                    Status.TO_DO,
                    startDate,
                    finDate,
                    repeatEveryDayOfWeek,
                    repeatEveryDayOfMonth,
                    repeatEveryDayOfYear,
                    repeatThrough,
                    importance,
                    difficulty
                ))
                emit(State.Success())
            }

        } catch (e: Exception) {
            emit(State.Error(e.localizedMessage))
        }
    }

    fun updateTask(
        taskId: Int,
        title: String?,
        info: String?,
        status: Status?,
        startDate: Date?,
        finDate: Date?,
        repeatEveryDayOfWeek: Weekday? = null,
        repeatEveryDayOfMonth: Int? = null, //от 1 до 31
        repeatEveryDayOfYear: Int? = null, // от 1 до 366
        repeatThrough: Date? = null,
        importance: Int? = null,
        difficulty: Int? = null
    ): Flow<State<Unit>> = flow {
        try {
            emit(State.Loading())

            if (startDate != null && finDate != null) {
                if (startDate.time > finDate.time
                ) {
                    emit(State.Error(message = "Время начала больше времени окончания"))
                } else if (repeatEveryDayOfMonth !in 1..31) {
                    emit(State.Error(message = "Неправильное число месяца"))
                } else if (repeatEveryDayOfYear !in 1..366) {
                    emit(State.Error(message = "Неправильное число года"))
                }
            }
            else if (importance != null && importance !in 1..5) {
                emit(State.Error(message = "Неправильно указана важность"))
            } else if (difficulty != null && difficulty !in 1..5) {
                emit(State.Error(message = "Неправильно указана сложность"))
            }  else {
                repository.updateTask(Task(
                    taskId,
                    title ?: "",
                    info,
                    status ?: Status.TO_DO,
                    startDate,
                    finDate,
                    repeatEveryDayOfWeek,
                    repeatEveryDayOfMonth,
                    repeatEveryDayOfYear,
                    repeatThrough,
                    importance,
                    difficulty
                ))
                emit(State.Success())
            }

        } catch (e: Exception) {
            emit(State.Error(e.localizedMessage))
        }
    }
}