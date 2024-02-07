package com.satyamthakur.bioguardian.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.satyamthakur.bioguardian.ui.composables.EndangeredNowSection
import com.satyamthakur.bioguardian.ui.composables.ExploreMoreSection
import com.satyamthakur.bioguardian.ui.composables.HeadingToolbar
import com.satyamthakur.bioguardian.ui.composables.HeroCard
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_background

@Composable
fun BioGuardianAppHomeScreen(paddingValues: PaddingValues, homeScreenNavController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        HeadingToolbar()
        Spacer(modifier = Modifier.height(20.dp))
        HeroCard()
        Spacer(modifier = Modifier.height(20.dp))
        ExploreMoreSection()
        Spacer(modifier = Modifier.height(20.dp))
        EndangeredNowSection(homeScreenNavController)
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPrev() {
    val navController = rememberNavController()
    BioGuardianAppHomeScreen(paddingValues = PaddingValues(), navController)
}