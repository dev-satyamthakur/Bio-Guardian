package com.satyamthakur.bioguardian.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satyamthakur.bioguardian.ui.composables.ExploreMoreSection
import com.satyamthakur.bioguardian.ui.composables.HeadingToolbar
import com.satyamthakur.bioguardian.ui.composables.HeroCard

@Composable
fun BioGuardianAppHomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        HeadingToolbar()
        Spacer(modifier = Modifier.height(20.dp))
        HeroCard()
        Spacer(modifier = Modifier.height(20.dp))
        ExploreMoreSection()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPrev() {
    BioGuardianAppHomeScreen()
}