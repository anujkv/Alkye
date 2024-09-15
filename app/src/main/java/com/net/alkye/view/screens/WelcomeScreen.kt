package com.net.alkye.view.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.net.alkye.R
import com.net.alkye.view.theme.AlkyeTheme
import com.net.alkye.view.theme.scillaFontFamilys
import com.net.alkye.view.theme.stawfordFontFamilys
import com.net.alkye.utils.ClassName

@Composable
fun WelcomeScreen(navController: NavController) {
    val textSize = dimensionResource(id = R.dimen.textSize18)
    Scaffold ( topBar = {},
        containerColor = colorResource(id = R.color.screen_clr)
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {

            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 120.dp, start = 20.dp, end = 20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo Icon",
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_logo_default_size))
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = stringResource(id = R.string.welcome),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontSize = dimensionResource(id = R.dimen.textSize18).value.sp,
                        fontFamily = stawfordFontFamilys,
                    )
                )

                Spacer(modifier = Modifier.height(40.dp))

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.quote),
                        contentDescription = "Image Quote",
                        modifier = Modifier.size(dimensionResource(id = R.dimen.image_quote_size))
                    )
                    Text(
                        text = stringResource(id = R.string.welcome_message),
                        Modifier.padding(top = 16.dp, start = 8.dp),
                        lineHeight = 30.sp,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = scillaFontFamilys,
                            fontStyle = FontStyle.Italic,
                        )
                    )
                }
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = {
                        redirectToHomeScreen(navController)

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    ),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                    modifier = Modifier
                        .width(dimensionResource(id = R.dimen.button_width))
                        .height(dimensionResource(id = R.dimen.button_height))
                ) {
                    Text(
                        text = stringResource(id = R.string.signup),
                        color = Color.White,
                        style = TextStyle(
                            fontSize = dimensionResource(id = R.dimen.textSize18).value.sp,
                            fontFamily = stawfordFontFamilys,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }

                Button(
                    onClick = {
                        redirectToHomeScreen(navController)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
                    modifier = Modifier
                        .width(dimensionResource(id = R.dimen.button_width))
                        .height(dimensionResource(id = R.dimen.button_height))
                ) {
                    Text(
                        text = stringResource(id = R.string.signin),
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = dimensionResource(id = R.dimen.textSize18).value.sp,
                            fontFamily = stawfordFontFamilys,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }

                Text(
                    text = stringResource(id = R.string.terms),
                    color = Color.Gray,
                    style = TextStyle(
                        fontSize = dimensionResource(id = R.dimen.textSize18).value.sp,
                        fontFamily = stawfordFontFamilys,
                        fontWeight = FontWeight.Normal
                    ),
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)
                )
            }
        }
    }
}

fun redirectToHomeScreen(navController: NavController) {
    /*navController.navigate("home") {
        popUpTo("welcome") {
            inclusive = true
        }
    }*/
    navController.navigate(ClassName.HOME_SCREEN) {
        popUpTo(ClassName.WELCOME_SCREEN) {
            inclusive = true
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    AlkyeTheme {
        val navController = rememberNavController()
        WelcomeScreen(navController = navController)
    }
}