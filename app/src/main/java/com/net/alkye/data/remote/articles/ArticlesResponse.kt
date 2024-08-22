package com.net.alkye.data.remote.articles

import androidx.room.Entity
import androidx.room.PrimaryKey


data class ArticlesResponse(
    val carousel_article: List<CarouselArticle>,
    val page: Int,
    val recent_article_list: List<RecentArticle>,
    val social_connect: List<SocialConnect>,
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
    val category: String,
    val type: String,
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
    val category: String,
    val type: String,
)

@Entity(tableName = "social_connect")
data class SocialConnect(
    @PrimaryKey
    val id: Int,
    val sub_title: String,
    val article_img: String
)