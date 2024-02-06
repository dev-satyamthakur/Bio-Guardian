package com.satyamthakur.bioguardian.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satyamthakur.bioguardian.ui.composables.AnimalImageView
import com.satyamthakur.bioguardian.ui.theme.Montserrat
import com.satyamthakur.bioguardian.ui.theme.Roboto
import com.satyamthakur.bioguardian.ui.theme.accentColor
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_background
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_onTertiaryContainer
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_tertiaryContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalDescriptionScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Cheetah",
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = md_theme_light_background,
                    titleContentColor = md_theme_light_onTertiaryContainer,
                ),
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        AnimalDescriptionScreenBody(paddingValues = paddingValues)
    }
}

@Composable
fun AnimalDescriptionScreenBody(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_light_background)
            .padding(paddingValues)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        AnimalImageView(image = "https://cdn.britannica.com/98/152298-050-8E45510A/Cheetah.jpg")
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Cheetah",
            fontFamily = Montserrat,
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
            color = md_theme_light_onTertiaryContainer,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Acinonyx jubatus",
            fontFamily = Roboto,
            fontSize = 16.sp,
            color = md_theme_light_onTertiaryContainer,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Facts",
            fontFamily = Montserrat,
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
            color = md_theme_light_onTertiaryContainer,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )
        Spacer(modifier = Modifier.height(10.dp))
        AnimalFactsCard()

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = md_theme_light_tertiaryContainer
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.End),
            border = BorderStroke(2.dp, md_theme_light_onTertiaryContainer)
        ) {
            Text(
                text = "KNOW MORE",
                color = md_theme_light_onTertiaryContainer,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun AnimalFactsCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = md_theme_light_tertiaryContainer
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        border = BorderStroke(2.dp, md_theme_light_onTertiaryContainer)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            AnimalFactItem(fact = "Cheetahs are the fastest land animal on Earth.")
            Spacer(modifier = Modifier.height(10.dp))
            AnimalFactItem(fact = "Cheetahs can give birth to 2-8 cubs at a time.")
            Spacer(modifier = Modifier.height(10.dp))
            AnimalFactItem(fact = "Can survive up to 10 days without water.")
        }
    }
}

@Composable
fun AnimalFactItem(fact: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(accentColor)
                .border(2.dp, md_theme_light_onTertiaryContainer, CircleShape),
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = fact,
            fontFamily = Roboto,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            modifier = Modifier.offset(y = -6.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AnimalDescPrev() {
    AnimalDescriptionScreen()
}


