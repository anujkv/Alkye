package com.net.alkye.data.local.article_details

import androidx.room.Entity

@Entity(tableName = "article_details")
data class ArticleDetails(
    val article_img: String,
    val category: String,
    val content: String,
    val content_type: String,
    val id: Int,
    val is_liked: Boolean,
    val is_viewed: Boolean,
    val publish_date: String,
    val recent_article_list: List<RecentArticle>,
    val special_keywords: List<SpecialKeyword>,
    val sub_title: String,
    val tab_items_keywords: List<TabItemsKeyword>,
    val title: String,
    val type: String
)

data class RecentArticle(
    val article_img: String,
    val category: String,
    val content_type: String,
    val id: Int,
    val is_liked: Boolean,
    val is_viewed: Boolean,
    val publish_date: String,
    val sub_title: String,
    val title: String,
    val type: String
)


data class SpecialKeyword(
    val id: Int,
    val keyword: String,
    val keyword_url: String
)

data class TabItemsKeyword(
    val id: Int,
    val title: String
)