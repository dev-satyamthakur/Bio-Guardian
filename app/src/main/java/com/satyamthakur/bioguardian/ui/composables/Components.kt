package com.satyamthakur.bioguardian.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
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
import com.satyamthakur.bioguardian.ui.theme.md_theme_dark_onPrimaryContainer
import com.satyamthakur.bioguardian.ui.theme.md_theme_dark_onTertiaryContainer
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_onTertiary
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_onTertiaryContainer
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_tertiaryContainer

@Composable
fun HeroCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = md_theme_light_tertiaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding()
        ) {
            Text(
                text = "Learn and Contribute \n" +
                        "to Conservation",
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = md_theme_light_onTertiaryContainer,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
            Row {
                Image(
                    modifier = Modifier
                        .height(150.dp)
                        .padding(top = 10.dp),
                    painter = painterResource(id = R.drawable.leaf),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.weight(1f))
                OutlinedButton(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                    ),
                    border = BorderStroke(2.dp, md_theme_light_onTertiaryContainer),
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(end = 20.dp, bottom = 16.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = md_theme_light_onTertiaryContainer
                    )
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                    Text(
                        text = "Get Started".uppercase(),
                        fontFamily = Montserrat,
                        fontSize = 12.sp,
                        color = md_theme_light_onTertiaryContainer
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreMoreCards(title: String) {
    OutlinedCard(
        modifier = Modifier.size(170.dp),
        colors = CardDefaults.cardColors(
            containerColor = md_theme_light_tertiaryContainer,
        ),
        border = BorderStroke(2.dp, md_theme_light_onTertiaryContainer),
        onClick = { /*TODO*/ }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                lineHeight = 24.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            OutlinedButton(
                modifier = Modifier.align(Alignment.End),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(2.dp, md_theme_light_onTertiaryContainer),
                onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = md_theme_light_onTertiaryContainer
                )
                Text(
                    text = "View",
                    fontFamily = Montserrat,
                    fontSize = 12.sp,
                    color = md_theme_light_onTertiaryContainer
                )
            }
        }
    }
}

@Preview()
@Composable
fun PrevExplore() {
    ExploreMoreCards("Nearby\nReserves")
}

@Preview()
@Composable
fun PrevHero() {
    HeroCard()
}