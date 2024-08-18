package com.net.alkye.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert

@Dao
interface ArticlesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: ArticlesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCarouselArticles(carouselArticles: List<CarouselArticle>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecentArticles(recentArticles: List<RecentArticle>)

    @Transaction
    @Query("SELECT * FROM articles")
    suspend fun getArticles(): List<ArticlesEntity>

    @Query("SELECT * FROM carousel_article WHERE id = :id")
    suspend fun getCarouselArticleById(id: Int): CarouselArticle

    @Query("SELECT * FROM recent_article WHERE id = :id")
    suspend fun getRecentArticleById(id: Int): RecentArticle

    @Query("DELETE FROM articles")
    suspend fun deleteAll()


}