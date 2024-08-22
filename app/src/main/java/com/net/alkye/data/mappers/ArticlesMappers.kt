package com.net.alkye.data.mappers

import com.net.alkye.data.remote.articles.CarouselArticle
import com.net.alkye.data.remote.articles.RecentArticle

/*Mapped Database to Local*/
fun RecentArticle.toRecentArticlesEntity(): com.net.alkye.data.local.articles.RecentArticle {
    return com.net.alkye.data.local.articles.RecentArticle(
        article_img = article_img,
        content_type = content_type,
        id = id,
        is_liked = is_liked,
        is_viewed = is_viewed,
        publish_date = publish_date,
        sub_title = sub_title,
        title = title,
        type = type,
        category = category
    )
}

fun CarouselArticle.toCarouselArticlesEntity(): com.net.alkye.data.local.articles.CarouselArticle {
    return com.net.alkye.data.local.articles.CarouselArticle(
        article_img = article_img,
        content_type = content_type,
        id = id,
        is_liked = is_liked,
        is_viewed = is_viewed,
        publish_date = publish_date,
        sub_title = sub_title,
        title = title,
        type = type,
        category = category
    )
}

/*fun ArticlesResponse.toArticlesEntity(): com.net.alkye.data.local.ArticlesEntity {
    return com.net.alkye.data.local.ArticlesEntity(
        page = page,
        carousel_article = carousel_article.map { it.toCarouselArticlesEntity() },
        recent_article_list = recent_article_list.map { it.toRecentArticlesEntity() },
        total_pages = total_pages,
        total_results = total_results
    )
}*/

/*Mapped Local to Database*/
fun com.net.alkye.data.local.articles.RecentArticle.toRecentArticles(): RecentArticle {
    return RecentArticle(
        article_img = article_img,
        content_type = content_type,
        id = id,
        is_liked = is_liked,
        is_viewed = is_viewed,
        publish_date = publish_date,
        sub_title = sub_title,
        title = title,
        type = type,
        category = category
    )
}

fun com.net.alkye.data.local.articles.CarouselArticle.toCarouselArticles(): CarouselArticle {
    return CarouselArticle(
        article_img = article_img,
        content_type = content_type,
        id = id,
        is_liked = is_liked,
        is_viewed = is_viewed,
        publish_date = publish_date,
        sub_title = sub_title,
        title = title,
        type = type,
        category = category
    )
}

/*fun com.net.alkye.data.local.ArticlesEntity.toArticles(): ArticlesResponse{
    return ArticlesResponse(
        page = page,
        carousel_article = carousel_article.map { it.toCarouselArticles() },
        recent_article_list = recent_article_list.map { it.toRecentArticles() },
        total_results = total_results,
        total_pages = total_pages
    )
}*/

