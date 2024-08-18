package com.net.alkye.data.remote

data class ArticlesResponse(
    val carousel_article: List<CarouselArticle>,
    val page: Int,
    val recent_article_list: List<RecentArticle>,
    val total_pages: Int,
    val total_results: Int
)

data class CarouselArticle(
    val article_img: String,
    val content_type: String,
    val id: Int,
    val is_liked: Boolean,
    val is_viewed: Boolean,
    val publish_date: String,
    val sub_title: String,
    val title: String,
    val type: String
)

data class RecentArticle(
    val article_img: String,
    val content_type: String,
    val id: Int,
    val is_liked: Boolean,
    val is_viewed: Boolean,
    val publish_date: String,
    val sub_title: String,
    val title: String,
    val type: String
)