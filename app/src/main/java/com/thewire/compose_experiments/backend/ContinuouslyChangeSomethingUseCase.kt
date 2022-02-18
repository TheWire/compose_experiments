package com.thewire.compose_experiments.backend

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

const val TAG = "CHANGER"


class ContinuouslyChangeSomethingUseCase(private val liveData: MutableLiveData<Int>) {
    private val scope = CoroutineScope(Dispatchers.IO)
    fun start() {
        scope.launch {
            while (true) {
                val rand = Random.nextInt(0, 100)
                liveData.postValue(rand)
                Log.d(TAG, "$rand")
                delay(1000)
            }
        }
    }

    fun stop() {
        scope.coroutineContext.cancelChildren()
    }
}

class ContinuouslyChangeSomethingUseCaseSuspend(private val liveData: MutableLiveData<Int>) {
    suspend fun start() {
        withContext(Dispatchers.IO) {
            while (true) {
                val rand = Random.nextInt(0, 100)
                liveData.postValue(rand)
                Log.d(TAG, "$rand")
                delay(1000)
            }
        }
    }
}

class ContinuouslyChangeSomethingUseCaseStateFlowSuspend(private val stateFlow: MutableStateFlow<Int>) {
    suspend fun start() {
        withContext(Dispatchers.IO) {
            while (true) {
                val rand = Random.nextInt(0, 100)
                stateFlow.value = rand
                Log.d(TAG, "$rand")
                delay(1000)
            }
        }
    }
}

class ContinuouslyChangeSomethingUseCaseStateFlow {
    private var scope = CoroutineScope(Dispatchers.IO)
    val stateFlow = MutableStateFlow(0)
    var isStarted = false
        get() = field
        private set(value) {
            field = value
        }
    var isPaused = false
        get() = field
    private set(value) {
        field = value
    }

    fun start(): StateFlow<Int> {
        if(!isStarted || isPaused) {
            isPaused = false
            scope.launch {
                isStarted = true
                while(this.isActive) {
                    delay(1000)
                    stateFlow.value++
                }
            }
        }
        return stateFlow
    }

    fun stop() {
        scope.coroutineContext.cancelChildren()
        isStarted = false
        isPaused = false
    }

    fun pause() {
        println("changer paused")
        isPaused = true
        scope.coroutineContext.cancelChildren()
    }


    fun reset() {
        stateFlow.value = 0
    }
}