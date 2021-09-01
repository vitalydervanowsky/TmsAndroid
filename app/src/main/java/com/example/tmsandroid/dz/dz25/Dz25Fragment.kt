package com.example.tmsandroid.dz.dz25

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentDz25Binding
import kotlinx.coroutines.*

class Dz25Fragment : Fragment() {
    private var _binding: FragmentDz25Binding? = null
    private val binding get() = _binding!!
    private val uiScope = CoroutineScope(Dispatchers.IO)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDz25Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            bTask1.setOnClickListener {
                tvConsole.text = ""
                log(getString(R.string.task1))
                uiScope.launch {
                    withContext(Dispatchers.IO) { fetchTwoFiles() }
                    log("both files are downloaded")
                }
            }

            bTask2.setOnClickListener {
                tvConsole.text = ""
                log(getString(R.string.task2))
                uiScope.launch {
                    fetchTwoFilesWithContextIO()
                    log("both files are downloaded")
                }
            }

            bTask3.setOnClickListener {
                tvConsole.text = ""
                log(getString(R.string.task3))
                uiScope.launch {
                    fetchTwoFilesWithUiScopeLaunch()
                    log("both files are downloaded")
                }
            }

            bTask4.setOnClickListener {
                tvConsole.text = ""
                log(getString(R.string.task4))
                uiScope.launch {
                    fetchTwoFilesWithCoroutineScopeLaunch()
                    log("both files are downloaded")
                }
            }

            bTask5.setOnClickListener {
                tvConsole.text = ""
                log(getString(R.string.task5))
                val coroutineScope = CoroutineScope(Dispatchers.Default)
                coroutineScope.launch {
                    launch {
                        log("my first coroutine")
                    }
                    coroutineScope {
                        launch {
                            delay(500)
                            log("inside child coroutine")
                        }
                        delay(100)
                        log("inside inner scope")
                    }
                    log("end of my coroutine")
                }
            }

            bTask6.setOnClickListener {
                tvConsole.text = ""
                log(getString(R.string.task6))
                val coroutineScope = CoroutineScope(Dispatchers.IO)
                val first = coroutineScope.async {
                    log("First: Going to return value")
                    delay(1000) // 100
                    "First Async"
                }
                val second = coroutineScope.async {
                    log("Second: Going to return value")
                    delay(20000) // 400
                    "Second Async"
                }
                runBlocking {
                    delay(15000) // 300
                    log("Did you finished")
                    log("${first.await()} ${second.await()}")
                }
            }

            bTask7.setOnClickListener {
                tvConsole.text = ""
                log(getString(R.string.task7))
                val coroutineScope = CoroutineScope(Dispatchers.Default)
                coroutineScope.launch {
                    val request = launch {
                        GlobalScope.launch {
                            delay(1000)
                            log("job1: Am I affected by Job Cancellation?")
                        }
                        launch {
                            delay(100)
                            log("job2: I am a child of the request coroutine")
                            delay(1000)
                            log("job2: Will I reach this line?")
                        }
                    }
                    delay(500)
                    request.cancel()
                    delay(1000)
                    log("main: Who has survived after request cancellation?")
                }
            }
        }
    }

    private suspend fun fetchTwoFiles() {
        fetchFile1()
        fetchFile2()
    }

    private suspend fun fetchTwoFilesWithContextIO() = withContext(Dispatchers.IO) {
        fetchFile1WithContextIO()
        fetchFile2WithContextIO()
    }

    private suspend fun fetchTwoFilesWithUiScopeLaunch() = withContext(Dispatchers.IO) {
        uiScope.launch { fetchFile1WithContextIO() }
        uiScope.launch { fetchFile2WithContextIO() }
    }

    private suspend fun fetchTwoFilesWithCoroutineScopeLaunch() = withContext(Dispatchers.IO) {
        coroutineScope {
            launch { fetchFile1WithContextIO() }
            launch { fetchFile2WithContextIO() }
        }
    }

    private suspend fun fetchFile1WithContextIO() = withContext(Dispatchers.IO) {
        log("starting downloading of file1")
        delay(3000)
        log("downloading of file1 is finished")
    }

    private suspend fun fetchFile2WithContextIO() = withContext(Dispatchers.IO) {
        log("starting downloading of file2")
        delay(3000)
        log("downloading of file2 is finished")
    }

    private suspend fun fetchFile1() {
        log("starting downloading of file1")
        delay(3000)
        log("downloading of file1 is finished")
    }

    private suspend fun fetchFile2() {
        log("starting downloading of file2")
        delay(3000)
        log("downloading of file2 is finished")
    }

    private fun log(text: String) {
        Log.i("@@@@", text)
        binding.tvConsole.post {
            val str = binding.tvConsole.text.toString() + text + "\n"
            binding.tvConsole.text = str
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}