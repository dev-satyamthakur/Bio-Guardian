package com.satyamthakur.bioguardian

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.satyamthakur.bioguardian.ui.model.BottomNavigationItem
import com.satyamthakur.bioguardian.ui.navigation.Endpoints
import com.satyamthakur.bioguardian.ui.screens.AnimalDescriptionScreen
import com.satyamthakur.bioguardian.ui.screens.BioGuardianAppHomeScreen
import com.satyamthakur.bioguardian.ui.theme.BioGuardianTheme
import com.satyamthakur.bioguardian.ui.theme.accentColor
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_tertiaryContainer
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KProperty

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BioGuardianTheme {
                // A surface container using the 'background' color from the theme

                val bottomNavItems = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home
                    ),
                    BottomNavigationItem(
                        title = "Upload",
                        selectedIcon = Icons.Filled.Send,
                        unselectedIcon = Icons.Outlined.Send
                    ),
                    BottomNavigationItem(
                        title = "Settings",
                        selectedIcon = Icons.Filled.Settings,
                        unselectedIcon = Icons.Outlined.Settings
                    ),
                )

                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFAFDFB)
                ) {
                    Scaffold(
                        bottomBar = {
                            NavigationBar(
                                containerColor = md_theme_light_tertiaryContainer,
                            ) {
                                bottomNavItems.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        colors = NavigationBarItemDefaults.colors(
                                            indicatorColor = accentColor
                                        ),
                                        selected = selectedItemIndex == index,
                                        onClick = {
                                            selectedItemIndex = index
                                        },
                                        icon = {
                                            Icon(
                                                imageVector = if (selectedItemIndex == index)
                                                    item.selectedIcon else item.unselectedIcon,
                                                contentDescription = null
                                            )
                                        },
                                        label = {
                                            Text(text = item.title)
                                        },
                                    )
                                }
                            }
                        }
                    ) { paddingValues ->

                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = Endpoints.HOME_SCREEN) {
                            composable(Endpoints.HOME_SCREEN) {
                                BioGuardianAppHomeScreen(paddingValues, navController)
                            }
                            composable(Endpoints.ANIMAL_DESC) {
                                AnimalDescriptionScreen(paddingValues, navController)
                            }
                        }


                    }
                }
            }
        }
    }
}

