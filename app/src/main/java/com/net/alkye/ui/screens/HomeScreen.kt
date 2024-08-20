package com.net.alkye.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.net.alkye.R
import com.net.alkye.data.local.articles.ArticlesEntity
import com.net.alkye.data.local.articles.CarouselArticle
import com.net.alkye.data.local.articles.RecentArticle
import com.net.alkye.data.local.articles.SocialConnect
import com.net.alkye.data.local.loadArticlesFromAssets
import com.net.alkye.data.local.loadConfigFromAssets
import com.net.alkye.ui.theme.AlkyeTheme
import com.net.alkye.utils.ClassName
import com.net.alkye.utils.ImageUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var selectedItem by remember { mutableIntStateOf(0) }
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
                                painter = painterResource(id = R.drawable.logo),
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
                            .width(180.dp)
                            .height(45.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .align(Alignment.Bottom)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .padding(start = 14.dp, end = 14.dp)
                                .fillMaxSize()
                        ) {
                            Text(
                                text = "Search...",
                                color = Color.Gray,
                                modifier = Modifier.weight(1f)
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.search_icon),
                                contentDescription = "Search Icon"
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
            CustomBottomNavBar(
                navController = navController,
                selectedItem = selectedItem,
                onItemSelected = { index -> selectedItem = index }
            )
        },
        containerColor = colorResource(id = R.color.screen_clr)
    ) { innerPadding ->
        val scrollState = androidx.compose.foundation.rememberScrollState()

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(
                    state = scrollState,
                    enabled = true,
                    flingBehavior = ScrollableDefaults.flingBehavior()
                )
        ) {
            val articles: ArticlesEntity = loadArticlesFromAssets(context = LocalContext.current)

            Box {
                SetCarouselArticles(articles.carousel_article, navController)
            }

            Box(
                modifier = Modifier
                    .height(1000.dp)
                    .fillMaxWidth()
            ) {

                SetRecentArticles(articles.recent_article_list, navController)
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.black))
            ) {
                SetSocialConnect(articles.social_connect, navController)
            }
        }

    }

}

@Composable
fun CustomBottomNavBar(
    navController: NavController,
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
) {

    val menuList = loadConfigFromAssets(context = LocalContext.current).menu_list

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 40.dp
            )
            .clip(RoundedCornerShape(32.dp)),
        color = colorResource(id = R.color.white),
        contentColor = colorResource(id = R.color.white)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            menuList.forEachIndexed { index, icon ->
                Box(modifier = Modifier
                    .padding(8.dp)
                    .clickable {onItemSelected(index)}
                    .weight(1.0f)
                    .align(Alignment.CenterVertically),
                    Alignment.Center){
                    Image(
                        painter = painterResource(
                            id = if (selectedItem == index) {R.drawable.bg_circle}
                            else {R.drawable.bg_unselected_circle}
                        ),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                    var id = R.drawable.book_open
                    when (icon.article_img) {
                        "R.drawable.book_open" -> {
                            id = R.drawable.book_open
                        }

                        "R.drawable.bookmark" -> id = R.drawable.bookmark
                        "R.drawable.tv_icon" -> id = R.drawable.tv_icon
                        "R.drawable.bell" -> id = R.drawable.bell
                        "R.drawable.user_icon" -> id = R.drawable.user_icon
                        else -> {}
                    }
                    Icon(

                        painter = painterResource(id),
                        contentDescription = null,
                        tint = if (selectedItem == index) colorResource(id = R.color.white)
                        else colorResource(id = R.color.black)
                    )
                }
                /*IconButton(
                    onClick = { onItemSelected(index) },
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            color = if (selectedItem == index) Color.Black else Color.Transparent,
                            shape = CircleShape
                        )
                ) {
                    var id = R.drawable.book_open
                    when (icon.article_img) {
                        "R.drawable.book_open" -> {
                            id = R.drawable.book_open
                        }

                        "R.drawable.bookmark" -> id = R.drawable.bookmark
                        "R.drawable.tv_icon" -> id = R.drawable.tv_icon
                        "R.drawable.bell" -> id = R.drawable.bell
                        "R.drawable.user_icon" -> id = R.drawable.user_icon
                        else -> {}
                    }

                    Icon(

                        painter = painterResource(id),
                        contentDescription = null,
                        tint = if (selectedItem == index) colorResource(id = R.color.white)
                        else colorResource(id = R.color.black)
                    )
                }*/
            }
        }
    }

}



@Composable
fun SetCarouselArticles(carouselArticle: List<CarouselArticle>, navController: NavController) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        /*item(carouselArticle){ carouselArticle->
            CarouselItem(carouselArticle)
        }*/

        items(carouselArticle) { article ->
            CarouselItem(article, navController)
        }
    }
}

@Composable
fun CarouselItem(carouselArticle: CarouselArticle, navController: NavController) {
    Card(
        onClick = {
            navigateToArticleDetailScreen(carouselArticle.id, navController)
        },
        modifier = Modifier
            .width(280.dp)
            .height(360.dp)
            .padding(top = 16.dp, bottom = 4.dp),
        shape = RoundedCornerShape(
            topStart = 20.dp,
            topEnd = 0.dp,
            bottomEnd = 20.dp,
            bottomStart = 20.dp
        ),

        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
        ) {
            Image(
                painter = ImageUtils.imageDefaultFutureCarFromDrawable(R.drawable.home_top_row_img),
                /*painter = rememberAsyncImagePainter(
                    model = carouselArticle.article_img
                ),*/
                /*builder = {
                    scale(Scale.FILL)
                    transformations(CoilTransformation.RoundedCornersTransformation(10.dp.toPx()))
                },*/
                contentDescription = "Article Image",
                contentScale = ContentScale.Crop,
            )

            Image(
                painter = ImageUtils
                    .imageDefaultFutureCarFromDrawable(imageId = R.drawable.video_icon),
                contentDescription = "Video Icon",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopStart)
            )


            Image(
                painter = ImageUtils
                    .imageDefaultFutureCarFromDrawable(imageId = R.drawable.favourate_not_selected_icon),
                contentDescription = "Video Icon",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopEnd)
            )
        }


        /*Row(){}*/


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(colorResource(id = R.color.white))
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier.padding(
                    start = 4.dp, end = 4.dp,
                    top = 4.dp, bottom = 2.dp
                )
            ) {
                Image(
                    painter = ImageUtils.imageDefaultFutureCarFromDrawable(
                        imageId = R.drawable.dot_icon
                    ),
                    contentDescription = "Dot Icon",
                )
                Text(
                    text = carouselArticle.type,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 2.dp)
                )
            }
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("${carouselArticle.title}:")
                    }
                    append(" ${carouselArticle.sub_title}")
                },
                color = Color.Black,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = carouselArticle.publish_date,
                color = Color.Gray,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 2.dp, top = 18.dp)
            )
        }

    }

}

fun navigateToArticleDetailScreen(articleId: Int, navController: NavController) {
    navController.navigate("${ClassName.ARTICLE_DETAIL_SCREEN}/$articleId") {
        popUpTo(ClassName.WELCOME_SCREEN) {
            inclusive = false
        }
    }
}

@Composable
fun SetRecentArticles(recentArticleList: List<RecentArticle>, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 26.dp, bottom = 16.dp)
    ) {
        Text(
            text = "Recent Article",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 26.dp, bottom = 16.dp)
        )

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
        ) {

            items(recentArticleList.take(4)) { article ->
                RecentArticleItem(article, navController)
            }

            if (recentArticleList.size > 4) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 16.dp)
                            .align(Alignment.CenterHorizontally),
                        Alignment.Center
                    ) {
                        Button(
                            onClick = {
                                navController.navigate("allrecentarticlesscreen")
                            },
                            modifier = Modifier
                                .width(190.dp)
                                .padding(16.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.white)
                            )
                        ) {
                            Text(
                                text = "View all",
                                color = colorResource(id = R.color.black),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun RecentArticleItem(article: RecentArticle, navController: NavController) {
    Card(
        onClick = {
            navigateToArticleDetailScreen(article.id, navController)
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .padding(top = 5.dp)
            .background(colorResource(id = R.color.screen_clr)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.white))
        ) {
            Image(
                painter = ImageUtils.imageDefaultFutureCarFromDrawable(R.drawable.recent_article),
                /*painter = rememberAsyncImagePainter(
                    model = article.article_img
                ),*/
                /*builder = {
                    scale(Scale.FILL)
                    transformations(CoilTransformation.RoundedCornersTransformation(10.dp.toPx()))
                },*/
                contentDescription = "Article Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(160.dp)
                    .fillMaxHeight()
                    .background(colorResource(id = R.color.white))
            )



            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(8.dp)
                    .background(colorResource(id = R.color.white))
            ) {
                Image(
                    painter = ImageUtils.imageDefaultFutureCarFromDrawable(
                        imageId = R.drawable.video_icon
                    ),
                    contentDescription = "Video Icon",
                    modifier = Modifier.padding(8.dp)
                )

                Row(
                    modifier = Modifier.padding(
                        start = 8.dp, end = 8.dp,
                        top = 8.dp, bottom = 2.dp
                    )
                ) {
                    Image(
                        painter = ImageUtils.imageDefaultFutureCarFromDrawable(
                            imageId = R.drawable.dot_icon
                        ),
                        contentDescription = "Dot Icon",
                    )
                    Text(
                        text = article.type,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 2.dp)
                    )
                }

                Text(
                    text = "${article.title}:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(
                        start = 8.dp, end = 8.dp,
                        top = 4.dp, bottom = 2.dp
                    )
                )
                Text(
                    text = article.sub_title,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(
                        start = 8.dp, end = 8.dp,
                        top = 2.dp, bottom = 20.dp
                    )
                )

                Text(
                    text = article.publish_date,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.date_clr),
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, bottom = 4.dp, top = 110.dp)
                        .align(Alignment.Start)
                )
            }
        }


    }
}


@Composable
fun SetSocialConnect(articles: List<SocialConnect>, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 8.dp
            )
    ) {

        Text(
            text = "Social Connect",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.white),
            fontSize = 22.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 26.dp, bottom = 4.dp)

        )

        Text(
            text = "Stay update with my latest post\non your favorite platforms",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = colorResource(id = R.color.white),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(bottom = 50.dp)
        ) {
            items(articles) { article ->
                SocialItem(article, navController)
            }
        }
    }
}

@Composable
fun SocialItem(article: SocialConnect, navController: NavController) {
    Card(
        onClick = {
            /*navigateToArticleDetailScreen(carouselArticle.id,navController)*/
        },
        modifier = Modifier
            .width(240.dp)
            .height(360.dp)
            .padding(top = 16.dp, bottom = 4.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
        ) {
            Image(
                painter = ImageUtils.imageDefaultFutureCarFromDrawable(R.drawable.social_connet_img),
                contentDescription = "Article Image",
                contentScale = ContentScale.Crop,
            )

            Image(
                painter = ImageUtils
                    .imageDefaultFutureCarFromDrawable(imageId = R.drawable.insta_icon),
                contentDescription = "Video Icon",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopStart)
            )

        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(colorResource(id = R.color.white))
                .padding(8.dp)
        ) {
            Text(
                text = article.sub_title,
                color = Color.Black,
                modifier = Modifier.padding(4.dp)
            )
        }

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