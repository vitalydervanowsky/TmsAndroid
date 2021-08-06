package com.example.tmsandroid.dz.dz20

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Timer : ViewModel() {

    val liveData = MutableLiveData<String>()

    fun startTimer(mSeconds: Long) {
        object : CountDownTimer(mSeconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val s = "seconds remaining: " + millisUntilFinished / 1000
                liveData.value = s
            }

            override fun onFinish() {
                val s = "done!"
                liveData.value = s
            }
        }.start()
    }
}