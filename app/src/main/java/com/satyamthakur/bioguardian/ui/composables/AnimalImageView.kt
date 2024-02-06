package com.satyamthakur.bioguardian.ui.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.satyamthakur.bioguardian.R

@Composable
fun AnimalImageView(image: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        AsyncImage(
            placeholder = painterResource(id = R.drawable.image_place),
            modifier = Modifier.height(250.dp),
            model = image,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}