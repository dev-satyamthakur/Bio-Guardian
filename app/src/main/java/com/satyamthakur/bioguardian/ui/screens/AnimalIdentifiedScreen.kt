package com.satyamthakur.bioguardian.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.satyamthakur.bioguardian.data.entity.ResourceState
import com.satyamthakur.bioguardian.ui.viewmodel.AnimalViewModel
import com.satyamthakur.bioguardian.ui.viewmodel.PredictionViewModel

@Composable
fun AnimalIdentifiedScreen(
    animalViewModel: AnimalViewModel = hiltViewModel()
) {
    val animalResponse by animalViewModel.post.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        when (animalResponse) {
            is ResourceState.Loading -> {
                Log.d("MYAPPTAG", "Inside Loading")
            }

            is ResourceState.Success -> {
                Log.d("MYAPPTAG", "Inside Success")
                val response = (animalResponse as ResourceState.Success).data

                if (response != null) {
                    Log.d("MYAPPTAG", response[0].name.toString())
                }
            }

            is ResourceState.Error -> {
                val error = animalResponse as ResourceState.Error
                Log.d("MYAPPTAG", "Inside Error $error")
            }

        }
    }

}