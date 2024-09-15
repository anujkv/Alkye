package com.net.alkye.view.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.net.alkye.R
import com.net.alkye.utils.ClassName
import kotlinx.coroutines.delay

@Composable
fun SplashScreen (navController: NavController){
    Scaffold ( topBar = {},
        containerColor = colorResource(id = R.color.screen_clr)){innerPadding ->
        val rotationDuration = 3000L
        //State to trigger rotation animation
        val infinteTransition = rememberInfiniteTransition()

        val rotation by infinteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(2700, easing = LinearEasing)
            ), label = ""
        )

        LaunchedEffect(Unit) {
            delay(rotationDuration)
            navController.navigate(ClassName.WELCOME_SCREEN){
                popUpTo(ClassName.SPLASH_SCREEN){
                    inclusive = true
                }
            }
        }

        /*UI*/
        Box (
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            contentAlignment = Alignment.Center){

            AppLogo(rotation)
        }
    }

}

@Composable
fun AppLogo(rotation: Float) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_playstore),
        contentDescription = "Rotating Image",
        modifier = Modifier
            .size(100.dp)
            .graphicsLayer {
                rotationZ = rotation
            },
        contentScale = ContentScale.Crop
    )

}


@Preview
@Composable
fun SplashScreenPreview() {
    val navController = rememberNavController()
    SplashScreen(navController = navController)
}