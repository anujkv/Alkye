package com.net.alkye

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.net.alkye.navigation.AppNavigation
import com.net.alkye.ui.theme.AlkyeTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            AlkyeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    AppNavigation()
//                    HomeScreen()
                    innerPadding.calculateTopPadding()

                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier.fillMaxSize()
    .background(colorResource(id = R.color.black))) {
        Text(text = "Home Activity")
}

@Preview
@Composable
fun HomeScreenPreview() {
    AlkyeTheme {
        HomeScreen()
    }
}
