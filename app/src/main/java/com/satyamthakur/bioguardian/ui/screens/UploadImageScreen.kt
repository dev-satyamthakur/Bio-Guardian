package com.satyamthakur.bioguardian.ui.screens

import android.net.Uri
import android.widget.Space
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCameraBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.satyamthakur.bioguardian.ui.theme.Montserrat
import com.satyamthakur.bioguardian.ui.theme.Roboto
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_background

@Composable
fun UploadImageScreen(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_light_background)
            .padding(paddingValues)

    ) {
        Spacer(modifier = Modifier.height(10.dp))
        UploadImageScreenTitle()
        Spacer(modifier = Modifier.height(20.dp))
        SelectAnImageCardWithHeading()
    }
}

@Composable
fun UploadImageScreenTitle() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        text = "Upload",
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectAnImageCardWithHeading() {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let {
                imageUri = it
            }
        }
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Select an image",
            fontFamily = Roboto,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .width(screenWidth)
                .height(screenWidth - 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            border = BorderStroke(2.dp, Color.Black),
            onClick = { galleryLauncher.launch("image/*") }
        ) {
            if (imageUri == null) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.PhotoCameraBack,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                }
            } else {
                Image(
                    painter = rememberAsyncImagePainter(model = imageUri),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UploadImagePrev() {
    UploadImageScreen(paddingValues = PaddingValues())
}

