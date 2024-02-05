package com.satyamthakur.bioguardian.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.satyamthakur.bioguardian.R
import com.satyamthakur.bioguardian.ui.data.Animal
import com.satyamthakur.bioguardian.ui.data.animalsListData
import com.satyamthakur.bioguardian.ui.theme.Montserrat
import com.satyamthakur.bioguardian.ui.theme.Roboto
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_onTertiaryContainer
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_tertiaryContainer

@Composable
fun EndangeredNowSection() {
    Column() {
        EndangeredNowSectionHeading()
        Spacer(modifier = Modifier.height(14.dp))
        EndangeredAnimalsList()
    }
}

@Composable
fun EndangeredAnimalsList() {
    LazyRow(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(animalsListData) { animal ->
            EndangeredAnimalItemCard(animal = animal)
        }
    }
}

@Composable
fun EndangeredAnimalItemCard(
    animal: Animal
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = md_theme_light_tertiaryContainer
        ),
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .width(180.dp)
                .padding(16.dp),
        ) {
            Card {
                AsyncImage(
                    placeholder = painterResource(id = R.drawable.image_place),
                    model = animal.imageLink,
                    contentDescription = null,
                    modifier = Modifier.height(100.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = animal.name,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Text(
                text = animal.bioName,
                fontFamily = Roboto,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun EndangeredNowSectionHeading() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Endangered Now",
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = md_theme_light_onTertiaryContainer
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "view all",
            fontFamily = Montserrat,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = md_theme_light_onTertiaryContainer
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EndangeredNowPreview() {
    EndangeredNowSection()
}