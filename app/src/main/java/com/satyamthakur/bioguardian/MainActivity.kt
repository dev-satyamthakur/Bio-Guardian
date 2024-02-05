package com.satyamthakur.bioguardian

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.satyamthakur.bioguardian.data.api.ApiService
import com.satyamthakur.bioguardian.data.datasource.PostsDataSource
import com.satyamthakur.bioguardian.data.entity.ResourceState
import com.satyamthakur.bioguardian.ui.composables.HeroCard
import com.satyamthakur.bioguardian.ui.screens.BioGuardianAppHomeScreen
import com.satyamthakur.bioguardian.ui.theme.BioGuardianTheme
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_background
import com.satyamthakur.bioguardian.ui.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//
//    @Inject
//    lateinit var postData: PostsDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
//        GlobalScope.launch {
//            val res = postData.getPost()
//            Log.d("MainActivity", res.body().toString())
//        }

        setContent {
            BioGuardianTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = md_theme_light_background
                ) {
                    BioGuardianAppHomeScreen()
                }
            }
        }
    }
}
//
//@Composable
//fun ShowPost(postViewModel: PostViewModel = hiltViewModel()) {
//    val postRes by postViewModel.post.collectAsState()
//
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        when (postRes) {
//            is ResourceState.Loading -> {
//                Text(text = "Loading...", fontSize = 25.sp)
//            }
//            is ResourceState.Success -> {
//                val response = (postRes as ResourceState.Success).data
//                Text(text = response.body.toString(), fontSize = 25.sp)
//            }
//            is ResourceState.Error -> {
//
//            }
//        }
//    }
//
//}
