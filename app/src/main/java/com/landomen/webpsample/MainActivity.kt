package com.landomen.webpsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.landomen.webpsample.ui.screen.IntroScreen
import com.landomen.webpsample.ui.screen.JpgComparisonScreen
import com.landomen.webpsample.ui.screen.PngComparisonScreen
import com.landomen.webpsample.ui.theme.WebPSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WebPSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
private fun Content(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationTarget.INTRO.route) {
        composable(NavigationTarget.INTRO.route) {
            IntroScreen(
                onPngSelect = { navController.navigate(NavigationTarget.PNG_VS_WEBP.route) },
                onJpgSelect = { navController.navigate(NavigationTarget.JPG_VS_WEBP.route) },
                modifier = modifier
            )
        }
        composable(NavigationTarget.JPG_VS_WEBP.route) {
            JpgComparisonScreen(modifier)
        }
        composable(NavigationTarget.PNG_VS_WEBP.route) {
            PngComparisonScreen(modifier)
        }
    }

    BackHandler {
        navController.popBackStack()
    }
}

enum class NavigationTarget(val route: String) {
    INTRO("intro_screen"),
    JPG_VS_WEBP("jpg_vs_webp_screen"),
    PNG_VS_WEBP("png_vs_webp_screen")
}