package com.example.tmsandroid.dz.dz26alt.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.tmsandroid.dz.dz26alt.data.WordDatabase
import com.example.tmsandroid.dz.dz26alt.model.Word
import com.example.tmsandroid.dz.dz26alt.repository.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Word>>
    private val repository: WordRepository

    init {
        val wordDao = WordDatabase.getDatabase(application).wordDao()
        repository = WordRepository(wordDao)
        readAllData = repository.readAllData.asLiveData()
    }

    fun addWord(word: Word) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addWord(word)
        }
    }

    fun clearDb() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.clearDb()
        }
    }

    fun deleteWord(word: Word) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteWord(word)
        }
    }

}