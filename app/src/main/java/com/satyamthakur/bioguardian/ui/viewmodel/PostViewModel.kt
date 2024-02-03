package com.satyamthakur.bioguardian.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satyamthakur.bioguardian.data.entity.FakeApiResponse
import com.satyamthakur.bioguardian.data.entity.ResourceState
import com.satyamthakur.bioguardian.ui.respository.PostRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postRespository: PostRespository
) : ViewModel() {

    private val _post : MutableStateFlow<ResourceState<FakeApiResponse>> = MutableStateFlow(ResourceState.Loading())
    val post: StateFlow<ResourceState<FakeApiResponse>> = _post

    init {
        getPost()
    }

    private fun getPost() {
        viewModelScope.launch(Dispatchers.IO) {
            postRespository.getPost()
                .collectLatest { newsResponse ->
                    _post.value = newsResponse
                }
        }
    }

}