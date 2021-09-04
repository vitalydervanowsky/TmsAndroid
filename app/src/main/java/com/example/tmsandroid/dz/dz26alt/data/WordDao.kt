package com.example.tmsandroid.dz.dz26alt.data

import androidx.room.*
import com.example.tmsandroid.dz.dz26alt.model.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table3 ORDER BY word ASC")
    fun readAllWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWord(word: Word)

    @Query("DELETE FROM word_table3")
    suspend fun clearDb()

    @Delete
    suspend fun deleteWord(word: Word)
}