package com.net.alkye.data.repository

import com.net.alkye.data.local.ArticlesDao
import com.net.alkye.data.local.RecentArticle
import com.net.alkye.data.remote.AppApiServices
import com.net.alkye.di.ArticlesRepository
import com.net.alkye.utils.NetworkUtil
import com.net.alkye.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/*
class ArticlesRepositoryImpl @Inject constructor(
    private val articlesDao: ArticlesDao,
    private val appApiServices: AppApiServices,
    private val networkUtil: NetworkUtil
): ArticlesRepository{
    override suspend fun getRecentArticles(): Flow<Resource<List<RecentArticle>>> {
        return flow {
            emit(Resource.Loading(true))

            val localRecentArticles = articlesDao.getRecentArticles()

            if(networkUtil.isNetworkAvailable()){
                val remoteRecentArticles = try {
                    val response = appApiServices.getArticles()
                    response.recent_article_list
                }catch (e:Exception){
                    e.printStackTrace()
                }

            }
            emit(Resource.Success(
                data = localRecentArticles
            ))
        }
    }

    override suspend fun getCarouselArticles(): Flow<Resource<List<RecentArticle>>> {
        TODO("Not yet implemented")
    }

}*/
