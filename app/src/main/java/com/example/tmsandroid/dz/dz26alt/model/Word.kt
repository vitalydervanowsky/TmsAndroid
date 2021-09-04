package com.example.tmsandroid.dz.dz26alt.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table3")
data class Word(
    @PrimaryKey @ColumnInfo(name = "word")
    val word: String
)