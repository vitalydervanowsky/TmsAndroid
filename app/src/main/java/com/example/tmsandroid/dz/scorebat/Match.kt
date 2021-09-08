package com.example.tmsandroid.dz.scorebat

data class Match(
    val competition: String,
    val competitionUrl: String,
    val date: String,
    val matchviewUrl: String,
    val thumbnail: String,
    val title: String,
    val videos: List<Video>
)