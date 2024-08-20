package com.net.alkye.data.local.articles

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticlesEntity(
    @PrimaryKey(autoGenerate = true)
    val page: Int,
    val recent_article_list: List<RecentArticle>,
    val carousel_article: List<CarouselArticle>,
    val social_connect: List<SocialConnect>,
    val total_pages: Int,
    val total_results: Int
)

@Entity(tableName = "carousel_article")
data class CarouselArticle(
    @PrimaryKey
    val id: Int,
    val type: String,
    val title: String,
    val sub_title: String,
    val publish_date: String,
    val article_img: String,
    val content_type: String,
    val is_liked: Boolean,
    val is_viewed: Boolean
)

@Entity(tableName = "recent_article")
data class RecentArticle(
    @PrimaryKey
    val id: Int,
    val type: String,
    val title: String,
    val sub_title: String,
    val publish_date: String,
    val article_img: String,
    val content_type: String,
    val is_liked: Boolean,
    val is_viewed: Boolean
)

@Entity(tableName = "social_connect")
data class SocialConnect(
    @PrimaryKey
    val id: Int,
    val sub_title: String,
    val article_img: String,
)