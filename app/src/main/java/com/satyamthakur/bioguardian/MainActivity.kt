package com.satyamthakur.bioguardian

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.CloudUpload
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.satyamthakur.bioguardian.ui.model.BottomNavigationItem
import com.satyamthakur.bioguardian.ui.navigation.BottomEndpoints
import com.satyamthakur.bioguardian.ui.navigation.Endpoints
import com.satyamthakur.bioguardian.ui.screens.AnimalDescriptionScreen
import com.satyamthakur.bioguardian.ui.screens.BioGuardianAppHomeScreen
import com.satyamthakur.bioguardian.ui.screens.UploadImageScreen
import com.satyamthakur.bioguardian.ui.theme.BioGuardianTheme
import com.satyamthakur.bioguardian.ui.theme.accentColor
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_background
import com.satyamthakur.bioguardian.ui.theme.md_theme_light_tertiaryContainer
import com.satyamthakur.bioguardian.ui.theme.onAccent
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KProperty

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BioGuardianTheme {
                // A surface container using the 'background' color from the theme
                val homeScreenNavController = rememberNavController()

                NavHost(
                    navController = homeScreenNavController,
                    startDestination = Endpoints.DASHBOARD
                ) {
                    composable(Endpoints.DASHBOARD) {
                        Dashboard(
                            homeScreenNavController = homeScreenNavController
                        )
                    }
                    composable(Endpoints.ANIMAL_DESC) {
                        AnimalDescriptionScreen(navController = homeScreenNavController)
                    }
                }
            }
        }
    }
}

@Composable
fun Dashboard(
    homeScreenNavController: NavController
) {
    val bottomNavItems = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        BottomNavigationItem(
            title = "Upload",
            selectedIcon = Icons.Filled.CloudUpload,
            unselectedIcon = Icons.Outlined.CloudUpload
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

    val bottomNavController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFAFDFB)
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar(
                    containerColor = accentColor,
                    modifier = Modifier.height(64.dp)
                ) {
                    bottomNavItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = onAccent,
                                selectedIconColor = Color.White,
                                unselectedIconColor = Color.White,
                                selectedTextColor = Color.White,
                                unselectedTextColor = Color.White
                            ),
                            selected = selectedItemIndex == index,
                            onClick = {
                                if (index == 0 && selectedItemIndex != 0) {
                                    bottomNavController.popBackStack()
                                    bottomNavController.navigate(BottomEndpoints.HOME_SCREEN)
                                }
                                if (index == 1 && selectedItemIndex != 1) {
                                    bottomNavController.popBackStack()
                                    bottomNavController.navigate(BottomEndpoints.UPLOAD)
                                }
                                selectedItemIndex = index
                            },
                            icon = {
                                Icon(
                                    imageVector = if (selectedItemIndex == index)
                                        item.selectedIcon else item.unselectedIcon,
                                    contentDescription = null
                                )
                            },
                            alwaysShowLabel = false,
                        )
                    }
                }
            }
        ) { paddingValues ->
            NavHost(
                navController = bottomNavController,
                startDestination = BottomEndpoints.HOME_SCREEN
            ) {
                composable(BottomEndpoints.HOME_SCREEN) {
                    BioGuardianAppHomeScreen(paddingValues, homeScreenNavController)
                }
                composable(BottomEndpoints.UPLOAD) {
                    UploadImageScreen(paddingValues = paddingValues)
                }
            }
        }
    }
}

