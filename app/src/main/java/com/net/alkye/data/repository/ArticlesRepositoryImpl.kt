package com.net.alkye.data.repository

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
