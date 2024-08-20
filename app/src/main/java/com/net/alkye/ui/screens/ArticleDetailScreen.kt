package com.net.alkye.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.net.alkye.R
import com.net.alkye.ui.theme.AlkyeTheme
import com.net.alkye.utils.ImageUtils
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailScreen(articleId: Int, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Spacer(modifier = Modifier.width(0.dp)) // Empty spacer to align items
                },
                modifier = Modifier
                    .height(120.dp)
                    .padding(top = 30.dp, start = 8.dp, end = 8.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.screen_clr)
                ),
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()

                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.backbutton_icon),
                                contentDescription = "Logo Icon",
                                modifier = Modifier
                                    .background(colorResource(id = R.color.screen_clr))
                            )
                        }
                    }
                },
                actions = {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()

                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "Logo Icon",
                                modifier = Modifier
                                    .background(colorResource(id = R.color.screen_clr))
                            )
                        }
                    }
                }
            )
        },
        containerColor = colorResource(id = R.color.screen_clr)
    ) { innerPadding ->

        val scrollState = androidx.compose.foundation.rememberScrollState()

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(
                    state =scrollState,
                    enabled = true,
                    flingBehavior = ScrollableDefaults.flingBehavior()
                )
        ) {
            Text(
                text = "Step Into Tomorrow:",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 2.dp)
            )
            Text(
                text = "Exploring Spatial Computing’s Impact On Industries And The Metaverse!",
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
            )

            Row(modifier = Modifier.padding(16.dp)) {
                Column(Modifier.weight(1F)) {
                    Text(
                        text = "Type",
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.date_clr)
                    )
                    Text(
                        text = "Article",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                }
                Column(Modifier.weight(1F)) {
                    Text(
                        text = "Category",
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.date_clr)
                    )
                    Text(
                        text = "Technology",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                }
                Column(Modifier.weight(1F)) {
                    Text(
                        text = "Date",
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.date_clr)
                    )
                    Text(
                        text = "26 Feb 2024",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                }

            }

            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(350.dp),
                shape = RoundedCornerShape(topStart = 12.dp, topEnd = 0.dp, bottomEnd = 12.dp, bottomStart = 12.dp) // Custom corner shapes
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Image(
                        painter = ImageUtils.imageDefaultFutureCarFromDrawable(
                            imageId = R.drawable.article_detals_img
                        ),
                        contentDescription = "Article Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(
                                RoundedCornerShape(
                                    topStart = 12.dp,
                                    topEnd = 12.dp,
                                    bottomEnd = 12.dp,
                                    bottomStart = 12.dp
                                )
                            ),
                        contentScale = ContentScale.Crop
                    )

                    Image(
                        painter = ImageUtils.imageDefaultFutureCarFromDrawable(
                            imageId = R.drawable.save_icon
                        ),
                        contentDescription = "Logo Icon",
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(start = 16.dp, top = 16.dp)
                    )

                    Image(
                        painter = ImageUtils.imageDefaultFutureCarFromDrawable(
                            imageId = R.drawable.share_icon
                        ),
                        contentDescription = "Bookmark Icon",
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(end = 16.dp, top = 16.dp)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    text = "Intro",
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = colorResource(id = R.color.date_clr),
                    modifier = Modifier.weight(0.6f).padding(start = 2.dp, end = 2.dp)
                )

                Text(
                    text = "Now: Simulating the enterprise",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.date_clr),
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "Introduction #1",
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = colorResource(id = R.color.date_clr),
                    modifier = Modifier.weight(0.6f).padding(start = 4.dp)
                )
            }


        }
    }

}

@Preview
@Composable
fun ArticleDetailScreenPreview() {
    AlkyeTheme {
        val navController = rememberNavController()
        ArticleDetailScreen(articleId = 1, navController = navController)
    }
}