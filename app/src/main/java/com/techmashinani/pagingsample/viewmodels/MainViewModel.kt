package com.techmashinani.pagingsample.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.techmashinani.pagingsample.models.Answer
import com.techmashinani.pagingsample.repository.AnswerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel(val answerRepository: AnswerRepository) : ViewModel() {
    private val parentJob = Job()
    private val viewModelContext = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(viewModelContext)

    val answersLiveData: MutableLiveData<List<Answer>> = MutableLiveData()

    init {
        getAnswers()
    }

    fun getAnswers() {
        scope.launch {

        }
    }

    override fun onCleared() {
        parentJob.cancel()
        super.onCleared()
    }
}