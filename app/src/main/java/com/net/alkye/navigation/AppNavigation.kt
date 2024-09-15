package com.net.alkye.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.net.alkye.view.screens.ArticleDetailScreen
import com.net.alkye.view.screens.HomeScreen
import com.net.alkye.view.screens.SplashScreen
import com.net.alkye.view.screens.WelcomeScreen
import com.net.alkye.utils.ClassName

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val articleid = 1

    NavHost(navController = navController, startDestination = ClassName.SPLASH_SCREEN) {
        composable(ClassName.SPLASH_SCREEN){ SplashScreen(navController) }
        composable(ClassName.WELCOME_SCREEN){ WelcomeScreen(navController) }
        composable(ClassName.HOME_SCREEN){ HomeScreen(navController) }
        composable(
            "${ClassName.ARTICLE_DETAIL_SCREEN}/{articleId}",
            arguments = listOf(navArgument("articleId") { type = NavType.IntType })
        ) { backStackEntry ->
            val articleId = backStackEntry.arguments?.getInt("articleId") ?: 0
            ArticleDetailScreen(articleId, navController)
        }
    }

}