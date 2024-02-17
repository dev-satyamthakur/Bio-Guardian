package com.satyamthakur.bioguardian.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satyamthakur.bioguardian.data.entity.AnimalPredictionResponse
import com.satyamthakur.bioguardian.data.entity.ResourceState
import com.satyamthakur.bioguardian.ui.respository.PredictionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class PredictionViewModel @Inject constructor(
    private val animalPredictionRepository: PredictionRepository
) : ViewModel() {

    private val _post : MutableStateFlow<ResourceState<AnimalPredictionResponse>> = MutableStateFlow(
        ResourceState.Loading())
    val post: StateFlow<ResourceState<AnimalPredictionResponse>> = _post

    init {
        getPost()
    }

    private fun getPost() {
        viewModelScope.launch(Dispatchers.IO) {
            animalPredictionRepository.getPost()
                .collectLatest { animalResponse ->
                    _post.value = animalResponse
                }
        }
    }

}