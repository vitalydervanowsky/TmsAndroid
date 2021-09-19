package com.example.tmsandroid.dz.scorebat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchViewModel : ViewModel() {

    val matchesLiveData = MutableLiveData<MatchResponse>()

    val currentMatchLiveData = MutableLiveData<Match>()

    private val apiScorebat = ApiMatch.create().getResponse()

    init {
        apiScorebat.enqueue(object : Callback<MatchResponse> {
            override fun onResponse(
                call: Call<MatchResponse>,
                response: Response<MatchResponse>
            ) {
                matchesLiveData.value = response.body()
            }

            override fun onFailure(call: Call<MatchResponse>, t: Throwable) {
            }
        })
    }

    fun setCurrentMatch(match: Match) {
        currentMatchLiveData.value = match
    }
}