package com.thewire.compose_experiments.presentation.ui.experimental1

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.thewire.compose_experiments.backend.ContinuouslyChangeSomethingUseCase
import com.thewire.compose_experiments.backend.ContinuouslyChangeSomethingUseCaseStateFlow
import com.thewire.compose_experiments.backend.ContinuouslyChangeSomethingUseCaseSuspend
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlin.random.Random

const val TAG = "EXPERIMENTAL1"

class ExperimentalViewModel1 : ViewModel(), DefaultLifecycleObserver {
    val something = MutableLiveData<Int>()
    val constantlyChanging = MutableLiveData<Int>()
    val constantlyChanging2 = MutableStateFlow(0)
    val constantlyChanging3 = mutableStateOf(0)
    lateinit var timer: CountDownTimer
    val time = mutableStateOf(0)
    var changer: ContinuouslyChangeSomethingUseCase? = null
    var changer2: ContinuouslyChangeSomethingUseCaseSuspend? = null
    var changer3: ContinuouslyChangeSomethingUseCaseStateFlow? = null

    init {
//        startTimer()
    }

    fun onEvent(event: ExperimentalViewModel1Event) {
        when (event) {
            ExperimentalViewModel1Event.OnStart -> {
                Log.d(TAG, "OnStart")
                start()
            }
            ExperimentalViewModel1Event.OnStop -> {
                Log.d(TAG, "OnStop")
                pause()
            }
            ExperimentalViewModel1Event.OnChangeSomething -> changeSomething()
            ExperimentalViewModel1Event.OnContinuouslyChangeSomething -> {
                continuouslyChangeSomethingViewModelStateFlow()
            }
            ExperimentalViewModel1Event.OnContinuouslyChangeSomethingStop -> {
                stopConstantlyChanging()
            }
            ExperimentalViewModel1Event.OnContinuouslyChangeSomethingReset -> resetConstantlyChanging()
        }
    }


    private fun resetConstantlyChanging() {
        changer3?.reset()
    }

    private fun stopConstantlyChanging() {
        changer3?.stop()
    }

    fun pause() {
        changer3?.pause()
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        pause()
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        start()
    }

    private fun start() {
        changer3?.apply {
            if(isPaused && isStarted) {
                start()
            }
        }
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        start()
    }

    private fun stop() {
        Log.d(TAG, "OnStop")
//        changer?.apply{
//            stop()
//        }
        changer3?.stop()
    }

    private fun startTimer() {
        timer = object : CountDownTimer(1000000, 1000) {
            override fun onTick(millisecs: Long) {
                val secs = (millisecs / 1000).toInt()
                if (secs != time.value) {
                    time.value = secs
                    println(secs)
                }
            }

            override fun onFinish() {
                println("timer finished")
            }
        }.start()
    }

    private fun changeSomething() {
        something.value = Random.nextInt(0, 100)
    }

    private fun continuouslyChangeSomething() {
        changer = ContinuouslyChangeSomethingUseCase(constantlyChanging).apply {
            start()
        }
    }

    private fun continuouslyChangeSomethingViewModel() {
        viewModelScope.launch {
            changer = ContinuouslyChangeSomethingUseCase(constantlyChanging).apply {
                start()
            }
        }
    }

    private fun continuouslyChangeSomethingViewModelSuspend() {
        viewModelScope.launch {
            changer2 = ContinuouslyChangeSomethingUseCaseSuspend(constantlyChanging).apply {
                start()
            }
        }
    }

    private fun continuouslyChangeSomethingViewModelStateFlow() {
        changer3 = ContinuouslyChangeSomethingUseCaseStateFlow().apply {
            viewModelScope.launch {
                start().collect {
                    println("collect $it")
                    constantlyChanging3.value = it
                }
            }
        }
    }
}