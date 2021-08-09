package com.example.tmsandroid.dz.dz20

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {

    val stringLiveData = MutableLiveData<String>()
    val isFinishLiveData = MutableLiveData<Boolean>()
    val isStartedLiveData = MutableLiveData<Boolean>()

    fun startTimer(mSeconds: Long) {
        viewModelScope.launch {
            object : CountDownTimer(mSeconds, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val s = "seconds remaining: " + millisUntilFinished / 1000
                    stringLiveData.value = s
                    isStartedLiveData.value = true
                }

                override fun onFinish() {
                    isFinishLiveData.value = true
                    isStartedLiveData.value = false
                }
            }.start()
        }
    }
}