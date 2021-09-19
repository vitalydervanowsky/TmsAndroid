package com.example.tmsandroid.dz.dz27

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MemeViewModel: ViewModel() {

    val memesLiveData = MutableLiveData<MemeResponse>()

    val currentMemeLiveData = MutableLiveData<Meme>()

    private val apiLastMemes = ApiMeme.create().getMemes()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            apiLastMemes.enqueue(object : Callback<MemeResponse> {
                override fun onResponse(call: Call<MemeResponse>, response: Response<MemeResponse>) {
                    memesLiveData.value = response.body()
                }

                override fun onFailure(call: Call<MemeResponse>, t: Throwable) {
                }
            })
        }
    }

    fun setCurrentMeme(meme: Meme) {
        currentMemeLiveData.value = meme
    }
}