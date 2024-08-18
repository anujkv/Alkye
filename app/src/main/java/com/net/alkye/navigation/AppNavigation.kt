package com.net.alkye.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.net.alkye.ui.screens.HomeScreen
import com.net.alkye.ui.screens.SplashScreen
import com.net.alkye.ui.screens.WelcomeScreen
import com.net.alkye.utils.ClassName

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ClassName.SPLASH_SCREEN) {
        composable(ClassName.SPLASH_SCREEN){ SplashScreen(navController) }
        composable(ClassName.WELCOME_SCREEN){ WelcomeScreen(navController) }
        composable(ClassName.HOME_SCREEN){ HomeScreen(navController) }
//        composable(ClassName.ARTICLE_DETAIL_SCREEN){ ArticleDetailScreen(navController) }
    }

}