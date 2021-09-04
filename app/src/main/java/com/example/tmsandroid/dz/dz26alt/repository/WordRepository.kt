package com.example.tmsandroid.dz.dz26alt.repository

import androidx.annotation.WorkerThread
import com.example.tmsandroid.dz.dz26alt.data.WordDao
import com.example.tmsandroid.dz.dz26alt.model.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val readAllData: Flow<List<Word>> = wordDao.readAllWords()

    @WorkerThread
    suspend fun addWord(word: Word) {
        wordDao.addWord(word)
    }

    @WorkerThread
    suspend fun clearDb() {
        wordDao.clearDb()
    }

    @WorkerThread
    suspend fun deleteWord(word: Word) {
        wordDao.deleteWord(word)
    }
}