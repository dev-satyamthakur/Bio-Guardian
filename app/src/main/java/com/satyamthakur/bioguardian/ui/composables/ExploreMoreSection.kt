package com.satyamthakur.bioguardian.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

val exploreTitles = listOf("Nearby\nReserves", "Conservation\nEfforts")

@Composable
fun ExploreMoreSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (title in exploreTitles) {
            ExploreMoreCards(title = title)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevExploreMoreSection() {
    ExploreMoreSection()
}