package com.example.storeapp.useCase

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

abstract class FlowUseCase<T> {

    private val _trigger = MutableStateFlow(true)

    /**
     * Exposes result of this use case
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    val resultFlow: Flow<T> = _trigger.flatMapLatest {
        performAction()
    }
    /**
     * Triggers the execution of this use case
     */
    suspend fun launch() {
        _trigger.emit(!(_trigger.value))
    }

    protected abstract suspend fun performAction() : Flow<T>
}