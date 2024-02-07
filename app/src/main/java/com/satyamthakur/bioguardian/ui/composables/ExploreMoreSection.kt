package com.satyamthakur.bioguardian.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satyamthakur.bioguardian.R
import com.satyamthakur.bioguardian.ui.theme.Montserrat
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_onTertiaryContainer
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_tertiaryContainer

val exploreTitles = listOf(
    "Nearby\nReserves", "Conservation\nEfforts",
    "Articles\n& Videos"
)

@Composable
fun ExploreMoreSection() {
    LazyRow(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(exploreTitles) { title ->
            ExploreMoreCard(title = title)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreMoreCard(title: String) {
    Card(
        modifier = Modifier.size(154.dp),
        colors = CardDefaults.cardColors(
            containerColor = md_theme_light_tertiaryContainer,
        ),
        onClick = {  }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = md_theme_light_onTertiaryContainer
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.align(Alignment.End).size(120.dp).offset(x = 10.dp ,y = 12.dp),
                painter = painterResource(id = R.drawable.polypodium_leaves),
                contentDescription = null
            )
        }
    }
}

@Preview()
@Composable
fun PrevExplore() {
    ExploreMoreCard("Nearby\nReserves")
}

@Preview(showBackground = true)
@Composable
fun PrevExploreMoreSection() {
    ExploreMoreSection()
}