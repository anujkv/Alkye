package com.net.alkye.di

import com.net.alkye.data.local.articles.RecentArticle
import com.net.alkye.utils.network.NetworkResource
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {
    suspend fun getRecentArticles(): Flow<NetworkResource<List<RecentArticle>>>

    suspend fun getCarouselArticles(): Flow<NetworkResource<List<RecentArticle>>>
}