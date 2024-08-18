package com.net.alkye.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.net.alkye.R
import com.net.alkye.ui.theme.AlkyeTheme
import com.net.alkye.ui.theme.scillaFontFamilys

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "")
            }, modifier = Modifier
                .height(80.dp)
                .padding(top = 40.dp),
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorResource(id = R.color.white)
            ),
            navigationIcon = {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 70.dp)
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painterResource(id = R.drawable.logo),
                        modifier = Modifier
                            .padding(start = 5.dp, top = 5.dp, bottom = 5.dp, end = 5.dp),
                        contentDescription = "Logo Icon"
                    )
                }
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = "Search Icon",
                        modifier = Modifier
                            .padding(5.dp)
                            .background(colorResource(id = R.color.teal_700)),
                    )
                }

            }
        )
    }, containerColor = colorResource(id = R.color.screen_clr)) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            // Example content
            Text("Home Screen Content", modifier = Modifier.padding(16.dp))
        }
        /*Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "")
                },
                modifier = Modifier.height(80.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_200)
                ),
                navigationIcon = {}

            )
        },
        content = { paddingValues ->
            // Your content for the HomeScreen goes here
            // For example, you can add a LazyColumn, or any other composables
            Box(modifier = Modifier.padding(paddingValues)) {
                // Example content
                Text("Home Screen Content", modifier = Modifier.padding(16.dp))
            }
        }
    )*/
    }

}


@Preview
@Composable
fun HomeScreenPreview() {
    AlkyeTheme {
        val navController = rememberNavController()
        HomeScreen(navController = navController)
    }

}