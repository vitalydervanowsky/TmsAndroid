package com.example.tmsandroid.dz.dz21

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Binder
import android.os.IBinder

class MyMediaPlayer : Service() {
    private var mediaPlayer: MediaPlayer? = null
    private val binder: IBinder = LocalBinder()

    override fun onBind(intent: Intent?): IBinder {
        mediaPlayer = MediaPlayer.create(this, Uri.parse(intent?.getStringExtra("stringUri")))
        mediaPlayer?.isLooping = true
        return binder
    }

    fun play() {
        mediaPlayer?.start()
    }

    fun pause() {
        if (mediaPlayer?.isPlaying == true)
            mediaPlayer?.pause()
        else
            mediaPlayer?.start()
    }

    fun stop() {
        mediaPlayer?.pause()
        mediaPlayer?.seekTo(0)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
    }

    inner class LocalBinder: Binder() {
        fun getMyMediaPlayerInstance(): MyMediaPlayer {
            return this@MyMediaPlayer
        }
    }
}