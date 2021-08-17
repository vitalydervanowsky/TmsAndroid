package com.example.tmsandroid.dz.dz21

import android.content.ComponentName
import android.content.Context.BIND_AUTO_CREATE
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentDz21Binding

class Dz21Fragment : Fragment() {
    private var _binding: FragmentDz21Binding? = null
    private val binding get() = _binding!!

    private var isBound = false
    private var myService: MyMediaPlayer? = MyMediaPlayer()

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            isBound = true
            val binder = service as MyMediaPlayer.LocalBinder
            myService = binder.getMyMediaPlayerInstance()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
            myService = null
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz21Binding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = Intent(context, MyMediaPlayer::class.java)
        val stringUri = "android.resource://com.example.tmsandroid/raw/audio"
        intent.putExtra("stringUri", stringUri)
        activity?.bindService(intent, connection, BIND_AUTO_CREATE)

        binding.apply {
            bLogin.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, LoginFragment())
                    .commit()
            }

            bPlay.setOnClickListener {
                if (isBound) myService?.play()
            }

            bPause.setOnClickListener {
                if (isBound) myService?.pause()
            }

            bStop.setOnClickListener {
                if (isBound) myService?.stop()
            }

            bStopService.setOnClickListener {
                if (isBound) {
                    activity?.unbindService(connection)
                    isBound = false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}