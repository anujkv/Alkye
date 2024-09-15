package com.net.alkye.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.net.alkye.R
import com.net.alkye.data.local.article_details.SpecialKeyword
import com.net.alkye.data.local.articles.ArticlesEntity
import com.net.alkye.data.local.articles.RecentArticle
import com.net.alkye.data.local.loadArticlesDetailsFromAssets
import com.net.alkye.data.local.loadArticlesFromAssets
import com.net.alkye.view.theme.AlkyeTheme
import com.net.alkye.view.theme.stawfordFontFamilys
import com.net.alkye.utils.images.ImageUtils

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
                        IconButton(onClick = {
                            navController.popBackStack()
                        },
                            modifier = Modifier
                                .size(48.dp)
                                .background(
                                    color = Color.Black,
                                    shape = CircleShape
                                )) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow_back),
                                contentDescription = stringResource(id =R.string.back_button_icon),
                                tint = Color.White,
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(end = 3.dp)
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
                                contentDescription = stringResource(id =R.string.logo_icon),
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
        val articleDetails =
            loadArticlesDetailsFromAssets(context = LocalContext.current, articleId)

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(32.dp))
                .padding(top = 28.dp),
            color = colorResource(id = R.color.screen_clr),
            contentColor = colorResource(id = R.color.black)
        ) {
            val scrollState = androidx.compose.foundation.rememberScrollState()

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(
                        state = scrollState,
                        enabled = true,
                        flingBehavior = ScrollableDefaults.flingBehavior()
                    )
            ) {
                Text(
                    text = articleDetails.title,
                    style = TextStyle(
                        fontSize = dimensionResource(id = R.dimen.textSize26).value.sp,
                        fontFamily = stawfordFontFamilys,
                        fontWeight = FontWeight.Bold,
                        lineHeight = dimensionResource(id = R.dimen.textSize33).value.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 2.dp
                    )
                )
                Text(
                    text = articleDetails.sub_title,
                    style = TextStyle(
                        fontSize = dimensionResource(id = R.dimen.textSize24).value.sp,
                        fontFamily = stawfordFontFamilys,
                        fontWeight = FontWeight.Normal,
                        lineHeight = dimensionResource(id = R.dimen.textSize33).value.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
                )

                Row(modifier = Modifier.padding(16.dp)) {
                    Column(Modifier.weight(1F)) {
                        Text(
                            text = stringResource(id = R.string.type),
                            style = TextStyle(
                                fontSize = dimensionResource(id = R.dimen.textSize14).value.sp,
                                fontFamily = stawfordFontFamilys,
                                fontWeight = FontWeight.Normal,
                                lineHeight = dimensionResource(id = R.dimen.textSize16).value.sp,
                                color = colorResource(id = R.color.date_clr)
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = articleDetails.type,
                            style = TextStyle(
                                fontSize = dimensionResource(id = R.dimen.textSize18).value.sp,
                                fontFamily = stawfordFontFamilys,
                                fontWeight = FontWeight.SemiBold,
                                lineHeight = dimensionResource(id = R.dimen.textSize21).value.sp,
                                color = Color.Black
                            ),
                        )
                    }
                    Column(Modifier.weight(1F)) {
                        Text(
                            text = stringResource(id = R.string.category),
                            style = TextStyle(
                                fontSize = dimensionResource(id = R.dimen.textSize14).value.sp,
                                fontFamily = stawfordFontFamilys,
                                fontWeight = FontWeight.Normal,
                                lineHeight = dimensionResource(id = R.dimen.textSize16).value.sp,
                                color = colorResource(id = R.color.date_clr)
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = articleDetails.category,
                            style = TextStyle(
                                fontSize = dimensionResource(id = R.dimen.textSize18).value.sp,
                                fontFamily = stawfordFontFamilys,
                                fontWeight = FontWeight.SemiBold,
                                lineHeight = dimensionResource(id = R.dimen.textSize21).value.sp,
                                color = Color.Black
                            ),
                        )
                    }
                    Column(Modifier.weight(1F)) {
                        Text(
                            text = stringResource(id = R.string.date),
                            style = TextStyle(
                                fontSize = dimensionResource(id = R.dimen.textSize14).value.sp,
                                fontFamily = stawfordFontFamilys,
                                fontWeight = FontWeight.Normal,
                                lineHeight = dimensionResource(id = R.dimen.textSize18).value.sp,
                                color = colorResource(id = R.color.date_clr)
                            ),
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = stringResource(id = R.string.date),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            style = TextStyle(
                                fontSize = dimensionResource(id = R.dimen.textSize18).value.sp,
                                fontFamily = stawfordFontFamilys,
                                fontWeight = FontWeight.SemiBold,
                                lineHeight = dimensionResource(id = R.dimen.textSize21).value.sp,
                                color = Color.Black
                            ),
                        )
                    }

                }

                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(350.dp),
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 0.dp,
                        bottomEnd = 12.dp,
                        bottomStart = 12.dp
                    ) // Custom corner shapes
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
                            contentDescription = stringResource(id =R.string.save_icon),
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
                        text = articleDetails.tab_items_keywords[0].title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontSize = dimensionResource(id = R.dimen.textSize18).value.sp,
                            fontFamily = stawfordFontFamilys,
                            fontWeight = FontWeight.Normal,
                            lineHeight = dimensionResource(id = R.dimen.textSize21).value.sp,
                            color = colorResource(id = R.color.date_clr)
                        ),
                        modifier = Modifier
                            .weight(0.4f)
                            .padding(start = 2.dp, end = 2.dp)
                    )

                    Text(
                        text = articleDetails.tab_items_keywords[1].title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontSize = dimensionResource(id = R.dimen.textSize18).value.sp,
                            fontFamily = stawfordFontFamilys,
                            fontWeight = FontWeight.Normal,
                            lineHeight = dimensionResource(id = R.dimen.textSize21).value.sp,
                            color = colorResource(id = R.color.black)
                        ),
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = articleDetails.tab_items_keywords[2].title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontSize = dimensionResource(id = R.dimen.textSize18).value.sp,
                            fontFamily = stawfordFontFamilys,
                            fontWeight = FontWeight.Normal,
                            lineHeight = dimensionResource(id = R.dimen.textSize21).value.sp,
                            color = colorResource(id = R.color.date_clr)
                        ),
                        modifier = Modifier
                            .weight(0.4f)
                            .padding(start = 4.dp)
                    )
                }

                HorizontalDivider(
                    modifier = Modifier.padding(top = 16.dp),
                    thickness = 2.dp,
                    color = colorResource(id = R.color.divider_clr)
                )


                CustomTextForArticle(articleDetails.content)

                GridLayoutForTextKeywords(articleDetails.special_keywords)

                val articles: ArticlesEntity =
                    loadArticlesFromAssets(context = LocalContext.current)

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 4.dp, bottom = 16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.related_articles),
                        style = TextStyle(
                            fontSize = dimensionResource(id = R.dimen.textSize22).value.sp,
                            fontFamily = stawfordFontFamilys,
                            fontWeight = FontWeight.Bold,
                            lineHeight = dimensionResource(id = R.dimen.textSize16).value.sp,
                            color = colorResource(id = R.color.black)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, bottom = 16.dp)
                    )

                    SetRelatedArticleDetails(articles.recent_article_list, navController)

                }


            }

        }
    }

}


@Composable
fun SetRelatedArticleDetails(article: List<RecentArticle>, navController: NavController) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        items(article) { article ->
            RelatedArticleItems(article, navController)
        }
    }
}


@Composable
fun RelatedArticleItems(article: RecentArticle, navController: NavController) {
    Card(
        onClick = {
            navigateToArticleDetailScreen(article.id, navController)
        },
        modifier = Modifier
            .width(280.dp)
            .height(420.dp)
            .padding(top = 4.dp, bottom = 4.dp),
        shape = RoundedCornerShape(20.dp),
        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
        ) {
            Image(
                painter =
                ImageUtils
                    .imageDefaultFutureCarFromDrawable(R.drawable.home_top_row_img),
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

        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
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
                    text = article.category,
                    style = TextStyle(
                        fontSize = dimensionResource(id = R.dimen.textSize14).value.sp,
                        fontFamily = stawfordFontFamilys,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = dimensionResource(id = R.dimen.textSize31).value.sp,
                        color = colorResource(id = R.color.black)
                    ),
                    modifier = Modifier.padding(start = 2.dp)
                )
            }
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = stawfordFontFamilys)) {
                        append("${article.title}:")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontFamily = stawfordFontFamilys,
                            fontWeight = FontWeight.Normal
                        )
                    ){append(" ${article.sub_title}")}
                },
                color = Color.Black,
                lineHeight = 24.sp,
                modifier = Modifier.padding(4.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = article.publish_date,
                style = TextStyle(
                    fontSize = dimensionResource(id = R.dimen.textSize14).value.sp,
                    fontFamily = stawfordFontFamilys,
                    fontWeight = FontWeight.Normal,
                    lineHeight = dimensionResource(id = R.dimen.textSize29).value.sp,
                    color = colorResource(id = R.color.date_clr)
                ),
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp, bottom = 16.dp)
            )
        }

    }

}

@Composable
fun GridLayoutForTextKeywords(specialKeywords: List<SpecialKeyword>) {
    val columns = 2
    val rows = (specialKeywords.size + columns - 1) / columns
    val itemHeight = 80.dp
    val verticalSpacing = 16.dp
    val gridHeight = rows * itemHeight + (rows - 1) * verticalSpacing

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(verticalSpacing),
        modifier = Modifier
            .height(gridHeight)
    ) {
        items(specialKeywords.size) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = CircleShape
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .background(Color.White)
                        .padding(5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = specialKeywords[item].keyword,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontSize = dimensionResource(id = R.dimen.textSize14).value.sp,
                            fontFamily = stawfordFontFamilys,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = dimensionResource(id = R.dimen.textSize16).value.sp,
                            color = colorResource(id = R.color.black)
                        ),
                    )

                }
            }
        }
    }
}

@Composable
fun CustomTextForArticle(text: String) {
    val firstLetter = text.firstOrNull()?.toString() ?: ""
    val restOfString = text.drop(1)

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row {
            Text(
                text = firstLetter,
                style = TextStyle(
                    fontSize = dimensionResource(id = R.dimen.textSize100).value.sp,
                    fontFamily = stawfordFontFamilys,
                    fontWeight = FontWeight.Bold,
                    lineHeight = dimensionResource(id = R.dimen.textSize100).value.sp,
                    color = colorResource(id = R.color.black)
                ),
                modifier = Modifier
                    .align(Alignment.Top)
                    .padding(end = 8.dp)
            )

            Text(
                text = restOfString,
                textAlign = TextAlign.Justify,
                modifier = Modifier.align(Alignment.CenterVertically),
                maxLines = 3,
                overflow = TextOverflow.Clip,
                style = TextStyle(
                    fontSize = dimensionResource(id = R.dimen.textSize18).value.sp,
                    fontFamily = stawfordFontFamilys,
                    fontWeight = FontWeight.Normal,
                    lineHeight = dimensionResource(id = R.dimen.textSize30).value.sp,
                    color = colorResource(id = R.color.black)
                ),
            )
        }

        Text(
            text = restOfString,
            textAlign = TextAlign.Justify,
            style = TextStyle(
                fontSize = dimensionResource(id = R.dimen.textSize18).value.sp,
                fontFamily = stawfordFontFamilys,
                fontWeight = FontWeight.Normal,
                lineHeight = dimensionResource(id = R.dimen.textSize30).value.sp,
                color = colorResource(id = R.color.black)
            ),
            modifier = Modifier.fillMaxWidth()
        )
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