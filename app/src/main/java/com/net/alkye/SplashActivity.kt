package com.net.alkye

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.net.alkye.navigation.AppNavigation

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            callAppConfigFile()
            AppNavigation()
        }
    }

    private fun callAppConfigFile() {

    }
}

