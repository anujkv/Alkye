package com.net.alkye.di

import com.net.alkye.data.local.articles.RecentArticle
import com.net.alkye.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {
    suspend fun getRecentArticles(): Flow<Resource<List<RecentArticle>>>

    suspend fun getCarouselArticles(): Flow<Resource<List<RecentArticle>>>
}