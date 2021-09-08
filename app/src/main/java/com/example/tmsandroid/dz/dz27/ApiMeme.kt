package com.example.tmsandroid.dz.dz27

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiMeme {

    @GET("memes/")
    fun getMemes(): Call<MemeResponse>

    companion object {
        private const val BASE_URL = "https://api.doge-meme.lol/v1/"
        private val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        private val okHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()

        fun create(): ApiMeme {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()
            return retrofit.create()
        }
    }
}